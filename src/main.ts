import "source-map-support/register";

import * as zmq from "zeromq";
import { graphql, buildSchema } from "graphql";


const schema = buildSchema(`
type Query {
  user(id: Number): User
}

type User { 
  name: String,
  fullName: String
}
`);

interface User {
	name: string;
	fullName: string;
}

const users: [User] = [
	{
		name: "deox",
		fullName: "Nils Ceberg"
	},
	{
		name: "truls",
		fullName: "Truls Trulsson"
	},
]

const root = {
  user: (args: { id: number }): User => {
	  if (args.id >= 0 && args.id < users.length) {
		  return users[args.id];
	  }
	  return null;
  }
};


let socket = zmq.socket("rep");
socket.connect("tcp://localhost:1339");
socket.on("message", async q => {
  const query = q.toString("utf-8");
  console.log(query);
  const result = await graphql(schema, query, root);
  console.log(result);
  socket.send(JSON.stringify(result.data));
});

