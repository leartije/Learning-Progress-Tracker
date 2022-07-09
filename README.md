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

### Stage 4/5: Retrieving statistics

**Description**

You have done a great job! As a reminder, our online learning platform offers its students four courses: Java, DSA, Databases, and Spring. To complete each of these courses, a student must earn a certain number of points that are different for each course: 600 for Java, 400 for DSA, 480 for Databases, and 550 for Spring. Students can enroll in any of the courses and take as many assignments as they want.

It would be a good idea to know which course is the most popular, which is the hardest to beat, and so on. For this purpose, you need to add new features to your program: it must provide the statistics about each course and track the performance of each student in each course.

Calculate the following:

- Find out which courses are the most and least popular ones. The most popular has the biggest number of enrolled students;
- Find out which course has the highest and lowest student activity. Higher student activity means a bigger number of completed tasks;
- Establish the easiest and hardest course. The easiest course has the highest average grade per assignment;
- Establish top learners for each course.

A student is enrolled in the course if the learning progress data contains at least one non-zero submission for that course. See the following example:
```
182365 4 0 0 8

182365 0 0 0 5

182366 0 8 0 4
```
On the first line, student `182365` completed one Java task and earned 4 points and also completed one Spring task and earned 8 point. On the second line the same student completed one Spring task and was awarded 5 points. On the third line student `182366` completed one DSA task and received 8 points and one Spring task and got 4 points. In this example, the student `182365` is considered to be enrolled in the Java and Spring courses, and the student `182366` is considered to be enrolled in the DSA and Spring courses.

One important thing. During statistics calculation, if multiple courses qualify for any of these categories, list the names of all such courses. If any course is already included in a category, it cannot be included in the opposite category. For example, if the Java Course is listed in the Highest Activity category, it cannot be listed in the Lowest Activity category.

Look at the example above. The most popular course is Spring (2 enrolled students), the least popular course is Databases (0 enrolled students), the highest activity is Spring (3 submissions), the lowest activity is Databases (0 submissions), the easiest course is DSA (average score is 8), and the hardest course is Java (average score is 4):

```
Type the name of a course to see details or 'back' to quit:
Most popular: Spring
Least popular: Databases
Highest activity: Spring
Lowest activity: Databases
Easiest course: DSA
Hardest course: Java
```

If no course falls into a certain category, for example if no students have enrolled in any of the courses or data can't be retrieved, print n/a. See more examples in the Examples section below.

Information about top learners should be presented as a list containing the following information: a student's ID, the total points for a course, and the course completion progress as a percentage:
```
Java

id     points completed

125684 423    70.5%

200751 420    70.0%

130400 405    67.5%
```
The list must be sorted by the total number of points in descending order, and if two or more students have the same number of points, they must be sorted by their ID in ascending order. Use the dot `.` character as the decimal point and RoundingMode.HALF_UP for rounding decimal numbers.

Also, use the following notation for course names: `Java`, `DSA`, `Databases`, `Spring`.

This stage has a lot of requirements, so you can use unit tests to break things down.

**Objectives**

In addition to the features of the previous stages, your program should:

- Add a new command to your program's toolkit: `statistics`. If users enter this command, your program should output the header: `Type the name of a course to see details or 'back' to quit` and six lines with the following information: `Most popular`, `Least popular`, `Highest activity`, `Lowest activity`, `Easiest course`, `Hardest course` with the names of the corresponding courses. After that, if users enter a course name, the program should display the details of this course, but if users enter a name that doesn't correspond to any of the courses, the program should print `Unknown course`. When the `back` command is entered, the program goes back to other available commands.
- When users enter the `statistics` command, your program must display the details about any course. When users type in the name of a course, the program should display the name of the course in the first line, then the column headers, and a list of student IDs, their total points in the respective course, and the percent of completion (one decimal place precision). If a course has no students, output only the name of the course and the column headers.
- Course details are available only after users enter `statistics`, they should not be available with the back. If users type in any course name before entering the `statistics` command, the program must respond with the `Unknown command!` message.
- Sort student lists by the total number of points in descending order and then by the ID in ascending order.

### Stage 5/5: Notification service

**Description**

Your Learning Progress Tracker is fine, but it is missing a few important features. We need to know which students have completed which courses and send the acknowledgments of their success, as well as personal certificates to them. Remember we asked students to specify their full names and email addresses? Now it's time to use this personal information to contact the top students.

Don't forget that each student who has completed a course should receive a letter of acknowledgment only once, as spamming is not a good idea. Use the following format for your messages:
```
To: %EMAIL_ADDRESS%
Re: Your Learning Progress
Hello, %FULL_USER_NAME%! You have accomplished our %COURSE_NAME% course!
```
where `%EMAIL_ADDRESS%,` `%FULL_USER_NAME%` and `%COURSE_NAME%` are placeholders for a student email address, full name, and a course name respectively.

Let's implement this notification feature so that we can use it with a single console command. Unit tests can help you to deliver the required functionality.

**Objectives**

- Add a new command to your program: notify. When users enter this command, your program should print a list of messages to students in the format above. Below the list, print the total number of students that should be notified, for example: Total 5 students have been notified.
- Make sure that your program generates only one notification for each trigger event. The trigger event is the completion of any course by a student.
- The messages generated by your program must contain the personal information of the students, such as an email address and the full name, as well as the name of the relevant course, if applicable.



