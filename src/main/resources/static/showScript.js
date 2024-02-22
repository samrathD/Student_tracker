//Accessing the button
let updateStudents = document.querySelectorAll(".update");
let deleteStudents = document.querySelectorAll(".delete");

// update.addEventListener("click",()=>{
//     console.log("Hello");
// })

for(let student of updateStudents){
    student.addEventListener("click",()=>{
        //Access the id of the student
        let uid = student.id;
        console.log(uid);
        //Direct user to the page that updates the student's information
        let updateEndpoint = `/students/update/${uid}`;
        window.location.href = updateEndpoint;
    })
}
for(let student of deleteStudents){
    student.addEventListener("click",()=>{
        //Access the id of the student
        let uid = student.id;
        //Direct user to the page that delets the student's information
        let deleteEndpoint = `/students/delete/${uid}`;
        window.location.href = deleteEndpoint;
    })
}