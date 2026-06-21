let currentStudentId = null;

async function loadStudents(){

    const response = await fetch(
        "http://localhost:8080/students"
    );

    const students = await response.json();

    let output = "";

    students.forEach(student => {

       output += `
<div class="student-card">
    <p><strong>ID:</strong> ${student.id}</p>
    <p><strong>Name:</strong> ${student.name}</p>
    <p><strong>Email:</strong> ${student.email}</p>

    <button onclick="deleteStudent(${student.id})">
        Delete
    </button>

    <button onclick="editStudent(${student.id},
        '${student.name}',
        '${student.email}')">
    Edit
    </button>
</div>
`;
    });

    document.getElementById("studentList")
            .innerHTML = output;
}

async function addStudent(){

    const student = {
        name: document.getElementById("name").value,
        email: document.getElementById("email").value,
        password: document.getElementById("password").value
    };

    console.log(student);

    const response = await fetch(
        "http://localhost:8080/students",
        {
            method: "POST",
            headers:{
                "Content-Type":"application/json"
            },
            body: JSON.stringify(student)
        }
    );
    document.getElementById("name").value = "";
    document.getElementById("email").value = "";
    document.getElementById("password").value = "";

    loadStudents();
}

async function deleteStudent(id){

    console.log("Deleting student:", id);
    await fetch(
        `http://localhost:8080/students/${id}`,
        {
            method:"DELETE"
        }
    );

    loadStudents();
}

function editStudent(id,name,email){

    currentStudentId = id;

    document.getElementById("name").value = name;
    document.getElementById("email").value = email;
}

async function updateStudent(){

    const student = {
        name: document.getElementById("name").value,
        email: document.getElementById("email").value,
        password: "123456"
    };

    await fetch(
        `http://localhost:8080/students/${currentStudentId}`,
        {
            method:"PUT",
            headers:{
                "Content-Type":"application/json"
            },
            body: JSON.stringify(student)
        }
    );
    document.getElementById("name").value = "";
    document.getElementById("email").value = "";
    document.getElementById("password").value = "";

currentStudentId = null;

    loadStudents();
}