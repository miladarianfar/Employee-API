
# Employee-API

A simple program for sending and receiving messages over the web

## Technologies
Project is created with:

* java version : 1.8
* springboot version : 2.5.4
* Hibernate
* MySQL
* spring rest


## API Reference

#### Get all employees

```http
  GET /api/employees
```

#### Get single employee by Id

```http
  GET /api/employees/${id}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `id`      | `int` | **Required**. Id of mail to fetch |

#### Get single user by firstname

```http
  GET /api/employees/firstname/{firstname}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `firstname`      | `String` | **Required**. username of user to fetch |

#### Get single user by lastname

```http
  GET /api/employees/lastname/{lastname}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `lastname`      | `String` | **Required**. username of user to fetch |

#### Get single user by email

```http
  GET /api/employees/email/{email}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `email`      | `String` | **Required**. username of user to fetch |


#### Count employees

```http
  POST /api/employees/countAll
```

#### Save employee

```http
  POST /api/employee
```

#### Delete employee

```http
  DELETE /api/employees/{id}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `id`      | `int` | **Required**. id of user to delete |

## Screenshots

![App Screenshot](https://github.com/miladarianfar/Employee-API/blob/main/rest-employee/screenshots/Capture.PNG)

![App Screenshot](https://github.com/miladarianfar/Employee-API/blob/main/rest-employee/screenshots/Capture2.PNG)

![App Screenshot](https://github.com/miladarianfar/Employee-API/blob/main/rest-employee/screenshots/Capture3.PNG)

![App Screenshot](https://github.com/miladarianfar/Employee-API/blob/main/rest-employee/screenshots/Capture4.PNG)
