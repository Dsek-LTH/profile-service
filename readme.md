The profile service handles the users of the system. It handles all requests regarding names, account information and such. It does not have hold the auth information, that is handled by the login-service.

# Endpoints



# Data
The following data will be awailable for all users in the system:
* id
* STIL
* firstname
* lastname
* guild (this will most likley link to another data set with class/year or external)
* email (for password reset / mail system)
* hidden? (bad name for a property, one should be able to say who can watch ones page, self/friends/dsek/logged in/all)

Some optional data may be stored:
* nickname
* birthday
* external webpage
* graduated
* telephone number (should be able to set who can see it)
* a personal comment (might even allow to alter their onw display page?)