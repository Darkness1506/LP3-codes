// SPDX-License-Identifier: MIT
pragma solidity ^0.8.19;

contract StudentData {
    struct Student {
        string name;
        uint256 rollno;
        string studentClass; // renamed from 'class' because 'class' is reserved
    }

    Student[] private students;
   
    function addStudent(string memory name, uint256 rollno, string memory studentClass) public {
        students.push(Student(name, rollno, studentClass));
    }

    function getStudentById(uint256 id) public view returns (string memory, uint256 rollno, string memory studentClass) {
        require(id < students.length, "Student does not exist in database.");
        return (students[id].name, students[id].rollno, students[id].studentClass); 
    }

    function getStudentCount() public view returns (uint256) {
        return students.length;
    }

    fallback() external payable {
        revert("Invalid call - function does not exist!");
    }

    receive() external payable {}
}
