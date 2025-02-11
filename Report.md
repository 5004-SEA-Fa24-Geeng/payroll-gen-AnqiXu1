# Report for Payroll Generator

This report helps you demonstrate your understanding of the concepts. You should write this report after you have completed the project. 

## Technical Questions

1. What does CSV stand for?
   Comma-Separated Values, a file format used for storing tabular data, such as spreadsheets or databases.

2. Why would you declare `List<IEmployee>` instead of `ArrayList<HourlyEmployee>`?
   Declaring List<IEmployee> allows for more flexibility, as it can hold any object that implements the IEmployee interface。

3. When you have one class referencing another object, such as storing that object as one of the attributes of the first class - what type of relationship is that called (between has-a and is-a)? 
   This is a has-a relationship because one class contains a reference to another object.

4. Can you provide an example of a has-a relationship in your code (if one exists)?
   There is a has-a relationship between PayrollGenerator and the List<IEmployee>.

5. Can you provide an example of an is-a relationship in your code (if one exists)?
   There is an is-a relationship between SalaryEmployee and IEmployee.

6. What is the difference between an interface and an abstract class?
   An interface defines a contract that classes must follow, but cannot provide implementation. 
   An abstract class can provide partial implementation and may include concrete methods.

7. What is the advantage of using an interface over an abstract class?
   Interfaces allow a class to implement multiple interfaces, offering more flexibility in design, while an abstract class is limited to single inheritance.

8. Is the following code valid or not? `List<int> numbers = new ArrayList<int>();`, explain why or why not. If not, explain how you can fix it.
   This code is not valid because generics cannot be used with primitive types like int. 
   It should be List<Integer> numbers = new ArrayList<>(); (using the wrapper class Integer).

9. Which class/method is described as the "driver" for your application?
   The main() method in the PayrollGenerator class.


10. How do you create a temporary folder for JUnit Testing?
    @Before or @BeforeEach。

## Deeper Thinking 

Salary Inequality is a major issue in the United States. Even in STEM fields, women are often paid less for [entry level positions](https://www.gsb.stanford.edu/insights/whats-behind-pay-gap-stem-jobs). However, not paying equal salary can hurt representation in the field, and looking from a business perspective, can hurt the company's bottom line has diversity improves innovation and innovation drives profits. 

Having heard these facts, your employer would like data about their salaries to ensure that they are paying their employees fairly. While this is often done 'after pay' by employee surveys and feedback, they have the idea that maybe the payroll system can help them ensure that they are paying their employees fairly. They have given you free reign to explore this idea.

Think through the issue / making sure to cite any resources you use to help you better understand the topic. Then write a paragraph on what changes you would need to make to the system. For example, would there be any additional data points you would need to store in the employee file? Why? Consider what point in the payroll process you may want to look at the data, as different people could have different pretax benefits and highlight that. 

The answer to this is mostly open. We ask that you cite at least two sources to show your understanding of the issue. The TAs will also give feedback on your answer, though will be liberal in grading as long as you show a good faith effort to understand the issue and making an effort to think about how your design to could help meet your employer's goals of salary equity.

We need to collect additional data such as the employee's gender, role, years of experience, and education level. This would help to understand whether certain groups are paid less for the same work.
[1] Gender pay gap in U.S. hasn’t changed much in two decades https://www.pewresearch.org/short-reads/2023/03/01/gender-pay-gap-facts/
[2] Global Gender Gap Report 2024 https://www.weforum.org/publications/global-gender-gap-report-2024/in-full/benchmarking-gender-gaps-2024-2e5f5cd886/
[3] What’s Behind the Pay Gap in STEM Jobs? https://www.gsb.stanford.edu/insights/whats-behind-pay-gap-stem-jobs