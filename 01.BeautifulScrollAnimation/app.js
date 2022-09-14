// observer allows us to see what componenets are visible
// here we add and remove the visibility characteristic to dynamically
// show and hide the cmp.
const observer = new IntersectionObserver((entries) => {
    entries.forEach((entry) => {
        console.log(entry);
        if(entry.isIntersecting){
            entry.target.classList.add('show');
        } else{
            entry.target.classList.remove('show');
        }
    });
});

const hiddenElements = document.querySelectorAll('.hidden');

// for each hidden element, check if it is being observed
hiddenElements.forEach((el) => observer.observe(el));