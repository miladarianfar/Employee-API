async function addEmployee()
{
    var firstname = document.getElementById('firstname').value;
    var lastname = document.getElementById('lastname').value;
    var email = document.getElementById('email').value;

    var data = {
        firstName : firstname,
        lastName : lastname,
        email : email
    };

    var response = postData(data);

    if((await response).status === 200){
        window.location.href = 'file:///D:/Visual%20studio%20code%20workspace/javascript_code/Employee/employees.html';
    }
}

async function postData(data)
{
    var response = fetch('http://localhost:8080/api/employee', {
        method : 'POST',
        headers :{
            'Content-Type' : 'application/json'
        },
        body : JSON.stringify(data)
    });

    return await response;
}