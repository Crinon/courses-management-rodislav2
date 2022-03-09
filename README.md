# courses-management-rodislav2

Routes :

courses
GET
http://localhost:8080/courses
POST
http://localhost:8080/courses
{
	"name":"perrin",
	"date":"2022-07-07T01:08:10Z"
}

students
GET
http://localhost:8080/students
POST
http://localhost:8080/students
{
	"nom": "crinon",
	"prenom": "nicolas",
	"email": "nico@gmail.fr",
	"password": "a"
}

rooms
GET
http://localhost:8080/rooms
POST
http://localhost:8080/rooms
{
	"number":226,
	"capacity":100
}
