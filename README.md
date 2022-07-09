# Learning-Progress-Tracker
## JetBrains Academy project in 5 stages

### Stage 1/5: No empty lines here 

**Description**

We are going to create a program that keeps track of the learning progress of multiple students. To accomplish this task, we should teach our program to read various data in string and numeric formats, do certain calculations, and output desired information. To begin with, we need to make our program interactive.

Any program designed to interact with users should have a user interface. In our case, we will implement the command-line interface so that users can enter different commands and receive the corresponding responses. In addition, for the benefit of our users, we will make commands case-insensitive and keep our responses reasonably informative.

These are our requirements, so let's get going!

**Objectives**

In this stage, your program should:

- Demonstrate that it is running by printing its title: `Learning Progress Tracker`.
- Wait for the commands. In this stage, the only command the program should recognize is `exit`. Once a user enters it, the program should print `Bye!` and quit.
- Detect if a user has entered a blank line and print No input in response.
- Print `Unknown command!` if a user enters an unknown command.

### Stage 2/5: Verify new users

**Description**

Let's add new functionality to our program by making it read the user credentials and verify whether they are correct or not. Every user must provide the following credentials: their first and last name and a valid email address.

The email address format is defined in RFC standards and is very complicated. In reality, email addresses are usually verified by sending a verification letter to which the user is required to reply and confirm the validity of the address. So in general, it is feasible just to check whether the provided string looks like an email address. It should contain the name part, the `@` symbol, and the domain part.

Checking names is even more intricate. We are not going to require users' photo ID and similar stuff, but take into your account that a learning platform may issue personal certificates of accomplishment, so it would not make any sense to issue a certificate with a name like ~D0MInAt0R~.

We need to put several limitations on the personal name format. First, users should state their full names that include the first and the last name. Accept only ASCII characters, from `A` to `Z` and from `a` to `z` as well as hyphens - and apostrophes '. For example, **Jean-Claude** and **O'Neill** are valid names, but **Stanisław Oğuz** is not. We respect every student, but we kindly request them to write their names using English-alphabet letters only.

In addition to the above, some students may have really long names like Robert Jemison Van de Graaff or John Ronald Reuel Tolkien. Do not restrict their right to indicate their full name during registration. In this case, use the following convention: the first part of the full name before the first blank space is the first name, and the rest of the full name should be treated as the last name.

We are not done yet! A name may contain one or more hyphens and/or apostrophes, but don't allow them as the first or the last character of any part of the name. Also, these characters cannot be adjacent to each other. The first name and the last name must be at least two characters long.

You may use unit tests to be sure you've implemented all name and email format requirements correctly.

**Objectives**

In addition to the features of the first stage, your program should:

- Recognize a new command: `add students` and respond with the following message: `Enter student credentials or 'back' to return.`
- Recognize a new `back` command and react as follows: if users want to finish adding new students, the program should print a message with the total number of students added during the session, for example: `Total 5 students have been added.` Otherwise, print a hint: `Enter 'exit' to exit the program.`
- The program should read user credentials from the console and check whether they match the established patterns. If the credentials match all patterns, print `The student has been added.` Otherwise, it should print which part of the credentials is not acceptable: `Incorrect first name`, `Incorrect last name` and `Incorrect email`.
- If the input cannot be interpreted as valid credentials, the program should print `Incorrect credentials`.

### Stage 3/5: A detailed record

**Description**

Once we are sure that the input information is correct, let's add a few new features to the program. This time, we will add users to the data store and update their records as the new learning data becomes available.

There will be some restrictions on adding students, though. First, you should assign a unique ID to each student so that you can access their records using the id rather than using their sensitive personal data. You may use a number or a string as an ID. Second, make sure that each user has only one account on the platform. Some users may have the same names, that's why you have their email addresses as their identity. This means that any email address can be used only once for registration.

The learning platform offers four courses: Java, Data Structures and Algorithms (DSA), Databases, and Spring. Each student can take any (or all) of these courses, complete tasks, pass tests, and submit their homework to receive points. By completing any task of any course, a student earns credit points that will be added to the student's total course score. These points can be zero, but they can't be negative.

Use the following input format to update records: a line of five elements separated by blank spaces. The first element is a student's ID, and the rest four elements are points earned by the student in the courses. For example:

25841 4 10 5 0

28405 0 8 7 5

Further, your program should be able to output information about the learning progress of any registered students. Keeping these conditions and restrictions in mind, don't forget to use unit tests to make sure your program works as intended.
Objectives

In addition to the features of the previous stages, your program should:

- Check if the provided email has been already used when adding information about students. If so, respond with the following message: `This email is already taken.`
- Recognize the new `list` command to print the `Students:` a header followed by the student IDs. The students must be listed in the order they were added. Remember, each ID must be unique. If there are no students to list, print `No students found`.
- Recognize the new `add points` and print the following message in response: `Enter an id and points or 'back' to return`. After that, the program must read learning progress data in the following format: `studentId number number number number`. The numbers correspond to the courses (Java, DSA, Databases, Spring). Number is a non-negative integer number. If there is no student with the specified ID, the program should print `No student is found for id=%s`. where %s is the invalid ID. Also, if any of the numbers are missing, or there is an extra number or any of the numbers do not meet the requirements mentioned above, the program should print `Incorrect points format`. If the learning progress data is entered in the correct format, and the specified user exists, the program should update the student's record and print `Points updated`. Once back is entered, the program must stop reading learning progress data.
- Recognize the `find` command and print the following message: `Enter an id or 'back' to return`. After that, if an ID is entered, the program should either print details of the student with the specified ID in this format: id points: `Java=%d; DSA=%d; Databases=%d; Spring=%d` where %d is the respective number of points earned by the student. If the ID cannot be found, print the error message: `No student is found for id=%s`. where %s is the invalid ID.
