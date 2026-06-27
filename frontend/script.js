const BASE_URL = "https://campuscore-demo.onrender.com";

let currentStudentId = null;

async function loadStudents() {
    try {
        const response = await fetch(`${BASE_URL}/students`);
        const students = await response.json();

        let output = "";

        students.forEach(student => {
            output += `
            <div class="student-card">
                <h3>👤 ${student.name}</h3>
                <p><strong>ID :</strong> ${student.id}</p>
                <p><strong>Email :</strong> ${student.email}</p>

                <div class="card-buttons">

                    <button class="edit-btn"
                        onclick="editStudent(${student.id}, '${student.name}', '${student.email}')">
                        Edit
                    </button>

                    <button class="delete-btn"
                        onclick="deleteStudent(${student.id})">
                        Delete
                    </button>

                </div>
            </div>
            `;
        });

        document.getElementById("studentList").innerHTML = output;

    } catch (error) {
        console.error("Error loading students:", error);
    }
}

async function addStudent() {

    const student = {
        name: document.getElementById("name").value,
        email: document.getElementById("email").value,
        password: document.getElementById("password").value
    };

    await fetch(`${BASE_URL}/students`, {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(student)
    });

    clearForm();
    loadStudents();
    alert("Student Added Successfully");
}

async function deleteStudent(id) {

    if (!confirm("Delete this student?")) return;

    await fetch(`${BASE_URL}/students/${id}`, {
        method: "DELETE"
    });

    loadStudents();
    alert("Student Deleted Successfully");
}

function editStudent(id, name, email) {

    currentStudentId = id;

    document.getElementById("name").value = name;
    document.getElementById("email").value = email;
    document.getElementById("password").value = "";

    window.scrollTo({
        top: 0,
        behavior: "smooth"
    });
}

async function updateStudent() {

    if (currentStudentId == null) {
        alert("Select a student using Edit.");
        return;
    }

    const student = {
        name: document.getElementById("name").value,
        email: document.getElementById("email").value,
        password: "123456"
    };

    await fetch(`${BASE_URL}/students/${currentStudentId}`, {
        method: "PUT",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(student)
    });

    clearForm();
    currentStudentId = null;
    loadStudents();

    alert("Student Updated Successfully");
}

function clearForm() {
    document.getElementById("name").value = "";
    document.getElementById("email").value = "";
    document.getElementById("password").value = "";
}