-- Create the employee database
CREATE DATABASE IF NOT EXISTS employee;
USE employee;

-- States table (lookup)
CREATE TABLE IF NOT EXISTS states (
    stateID INT PRIMARY KEY AUTO_INCREMENT,
    state_name VARCHAR(50) NOT NULL UNIQUE,
    state_abbreviation VARCHAR(2) NOT NULL UNIQUE
);

-- Cities table (lookup)
CREATE TABLE IF NOT EXISTS cities (
    cityID INT PRIMARY KEY AUTO_INCREMENT,
    city_name VARCHAR(100) NOT NULL,
    stateID INT NOT NULL,
    FOREIGN KEY (stateID) REFERENCES states(stateID)
);

-- Addresses table
CREATE TABLE IF NOT EXISTS addresses (
    addressID INT PRIMARY KEY AUTO_INCREMENT,
    street VARCHAR(255) NOT NULL,
    cityID INT NOT NULL,
    stateID INT NOT NULL,
    zip VARCHAR(10) NOT NULL,
    DOB VARCHAR(50),
    phone VARCHAR(20),
    emergency_contact VARCHAR(100),
    emergency_contact_phone VARCHAR(20),
    FOREIGN KEY (cityID) REFERENCES cities(cityID),
    FOREIGN KEY (stateID) REFERENCES states(stateID)
);

-- Employees table
CREATE TABLE IF NOT EXISTS employees (
    empid INT PRIMARY KEY AUTO_INCREMENT,
    Fname VARCHAR(50) NOT NULL,
    Lname VARCHAR(50) NOT NULL,
    email VARCHAR(100),
    HireDate VARCHAR(50),
    Salary DOUBLE NOT NULL,
    SSN VARCHAR(20) UNIQUE,
    addressID INT NOT NULL,
    FOREIGN KEY (addressID) REFERENCES addresses(addressID)
);

-- Job Titles table
CREATE TABLE IF NOT EXISTS job_titles (
    job_title_id INT PRIMARY KEY AUTO_INCREMENT,
    job_title VARCHAR(100) NOT NULL UNIQUE
);

-- Employee-JobTitles junction table (many-to-many)
CREATE TABLE IF NOT EXISTS employee_job_titles (
    empid INT NOT NULL,
    job_title_id INT NOT NULL,
    PRIMARY KEY (empid, job_title_id),
    FOREIGN KEY (empid) REFERENCES employees(empid),
    FOREIGN KEY (job_title_id) REFERENCES job_titles(job_title_id)
);

-- Payroll table
CREATE TABLE IF NOT EXISTS payroll (
    payID INT PRIMARY KEY AUTO_INCREMENT,
    payDate VARCHAR(50) NOT NULL,
    earnings DOUBLE NOT NULL,
    fedTax DOUBLE DEFAULT 0,
    fedMed DOUBLE DEFAULT 0,
    fedSS DOUBLE DEFAULT 0,
    stateTax DOUBLE DEFAULT 0,
    retire401k DOUBLE DEFAULT 0,
    healthCare DOUBLE DEFAULT 0,
    empid INT NOT NULL,
    FOREIGN KEY (empid) REFERENCES employees(empid)
);

-- Sample States
INSERT INTO states (state_name, state_abbreviation) VALUES
('Alabama', 'AL'),
('Alaska', 'AK'),
('Arizona', 'AZ'),
('Arkansas', 'AR'),
('California', 'CA'),
('Colorado', 'CO'),
('Connecticut', 'CT'),
('Delaware', 'DE'),
('Florida', 'FL'),
('Georgia', 'GA'),
('New York', 'NY'),
('Texas', 'TX'),
('Illinois', 'IL');

-- Sample Cities
INSERT IGNORE INTO cities (city_name, stateID) VALUES
('New York', (SELECT stateID FROM states WHERE state_abbreviation = 'NY')),
('Los Angeles', (SELECT stateID FROM states WHERE state_abbreviation = 'CA')),
('Chicago', (SELECT stateID FROM states WHERE state_abbreviation = 'IL')),
('Houston', (SELECT stateID FROM states WHERE state_abbreviation = 'TX')),
('Phoenix', (SELECT stateID FROM states WHERE state_abbreviation = 'AZ'));

-- Sample Job Titles
INSERT IGNORE INTO job_titles (job_title) VALUES
('Software Engineer'),
('Manager'),
('HR Specialist'),
('Accountant'),
('Designer');
