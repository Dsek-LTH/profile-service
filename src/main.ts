import "source-map-support/register";

import * as zmq from "zeromq";
import { graphql, buildSchema } from "graphql";


const schema = buildSchema(`
type Query {
  user(id: Int): User
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

const users: User[] = [
	{
		name: "deox",
		fullName: "Nils Ceberg"
	},
	{
		name: "truls",
		fullName: "Truls Trulsson"
	},
	{
		name: "bbq",
		fullName: "Viktor Claesson"
	},
];

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
  const operation = JSON.parse(q.toString("utf-8"));
  console.log(operation);
  const result = await graphql({
    contextValue: operation.context,
    schema,
    source: operation.query,
    variableValues: operation.variables,
    rootValue: root,
  });
  console.log(result);
  socket.send(JSON.stringify(result));
});

