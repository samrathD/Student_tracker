let add = document.querySelector(".add");
let update = document.querySelector(".update");
let deleteStudent = document.querySelector(".delete");
let display = document.querySelector(".display");

//Guide user to add student page
add.addEventListener("click",()=>{
    let addEndpoint = `/add.html`;
    window.location.href = addEndpoint;
})

display.addEventListener("click",()=>{
    let displayEndpoint = `/students/view`;
    window.location.href = displayEndpoint;
})