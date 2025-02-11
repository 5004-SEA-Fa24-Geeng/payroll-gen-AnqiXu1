/*
 * Students, build off this class. We are providing one sample test case as file reading is new to
 * you.
 *
 * NOTE: you may end up changing this completely depending on how you setup your project.
 *
 * we are just using .main() as we know that is an entry point that we specified.
 *
 */

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import student.PayrollGenerator;
import student.IEmployee;
import student.HourlyEmployee;
import student.SalaryEmployee;
import student.SimplePayStub;
import student.Builder;
import student.ITimeCard;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class TestPayrollGenerator {

    @TempDir
    static Path tempDir;


    @Test
    public void testFinalPayStub() throws IOException {
        // copy employees.csv into tempDir
        Path employees = tempDir.resolve("employees.csv");
        Files.copy(Paths.get("resources/employees.csv"), employees);

        // get the path of the paystubs.csv
        Path payStubs = tempDir.resolve("paystubs.csv");



        String[] args = {"-e", employees.toString(), "-t", "resources/time_cards.csv", // allowed,
                // this isn't
                // modified -
                // so safe
                "-o", payStubs.toString()};

        // run main method
        PayrollGenerator.main(args);



        String expectedPayStubs = Files
                .readString(Paths.get("resources/original/pay_stubs_solution_to_original.csv"));

        String actualPayStubs = Files.readString(payStubs);

        assertEquals(expectedPayStubs, actualPayStubs);


        // you could also read lines and compared the lists


    }
    @Test
    public void testHourlyEmployeePayroll_NormalHours() {
        HourlyEmployee emp = new HourlyEmployee("Alice", "E001", 20.0, 0, 0, 0);
        SimplePayStub stub = (SimplePayStub) emp.runPayroll(40);
        assertEquals(20 * 40, stub.getPay() + stub.getTaxesPaid(), 0.01);
        assertEquals(20 * 40, emp.getYTDEarnings(), 0.01);
    }
    @Test
    public void testHourlyEmployeePayroll_Overtime() {
        HourlyEmployee emp = new HourlyEmployee("Bob", "E002", 25.0, 0, 0, 0);
        SimplePayStub stub = (SimplePayStub) emp.runPayroll(45);
        assertEquals(25 * 40 + 25 * 1.5 * 5, stub.getPay() + stub.getTaxesPaid(), 0.01);
    }


    @Test
    public void testBuildHourlyEmployeeFromCSV() {
        String csv = "HOURLY,Alice,E001,20.0,50.0,1000.0,200.0";
        IEmployee emp = Builder.buildEmployeeFromCSV(csv);
        assertTrue(emp instanceof HourlyEmployee);
        assertEquals("Alice", emp.getName());
        assertEquals(20.0, emp.getPayRate(), 0.001);
    }

    @Test
    public void testBuildSalaryEmployeeFromCSV() {
        String csv = "SALARY,Bob,E002,60000.0,100.0,5000.0,1000.0";
        IEmployee emp = Builder.buildEmployeeFromCSV(csv);
        assertTrue(emp instanceof SalaryEmployee);
        assertEquals("Bob", emp.getName());
        assertEquals(60000.0, emp.getPayRate(), 0.001);
    }

    @Test
    public void testSimplePayStubToCSV() {
        HourlyEmployee emp = new HourlyEmployee("Dave", "E004", 30.0, 1000.0, 200.0, 50.0);
        SimplePayStub stub = new SimplePayStub(emp, 150.0, 750.0);
        String csv = stub.toCSV();
        assertEquals("Dave,750.00,150.00,1000.00,200.00", csv);
    }




}
