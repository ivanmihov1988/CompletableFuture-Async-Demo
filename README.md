You can run the project directly and test the 2 endpoints placing debuggers in the services and threads execution.

1. GET http://localhost:8080/user/23 (or any long number as an example userId)

example response:
{
    "id": 23,
    "name": "John Doe",
    "email": "johndoe@example.com",
    "preferences": "Dark mode, Email notifications",
    "score": 30
}

2. POST http://localhost:8080/log-activity

example body:
{
   "userId": "23",
   "action": "make payment"
}

