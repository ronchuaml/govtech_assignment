SET foreign_key_checks = 0;

DROP TABLE IF EXISTS user_roles;
DROP TABLE IF EXISTS `User`;
DROP TABLE IF EXISTS app_user;
DROP TABLE IF EXISTS Role;
DROP TABLE IF EXISTS Application;
DROP TABLE IF EXISTS Benefit;
DROP TABLE IF EXISTS SchemeCriteria;
DROP TABLE IF EXISTS Scheme;
DROP TABLE IF EXISTS Household;
DROP TABLE IF EXISTS Applicant;
DROP TABLE IF EXISTS Administrator;

SET foreign_key_checks = 1;


CREATE TABLE Applicant (
    id CHAR(36) PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    marital_status ENUM('single', 'married', 'widowed', 'divorced') NOT NULL,
    employment_status ENUM('employed', 'unemployed') NOT NULL,
    sex ENUM('male', 'female') NOT NULL,
    date_of_birth DATE NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

CREATE TABLE Household (
    id CHAR(36) PRIMARY KEY,
    applicant_id CHAR(36) NOT NULL,
    name VARCHAR(100) NOT NULL,
    relation ENUM('son', 'daughter', 'spouse', 'parent', 'other') NOT NULL,
    employment_status ENUM('employed', 'unemployed') NOT NULL,
    date_of_birth DATE NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    FOREIGN KEY (applicant_id) REFERENCES Applicant(id)
);

CREATE TABLE Scheme (
    id CHAR(36) PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    description TEXT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

CREATE TABLE scheme_criteria (
    id CHAR(36) PRIMARY KEY,
    scheme_id CHAR(36) NOT NULL,
    marital_status ENUM('single', 'married', 'widowed', 'divorced') DEFAULT NULL,
    employment_status ENUM('employed', 'unemployed') DEFAULT NULL,
    has_children BOOLEAN DEFAULT NULL,
    children_min_age INT DEFAULT NULL,
    children_max_age INT DEFAULT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    FOREIGN KEY (scheme_id) REFERENCES Scheme(id)
);

CREATE TABLE Benefit (
    id CHAR(36) PRIMARY KEY,
    scheme_id CHAR(36) NOT NULL,
    name VARCHAR(100) NOT NULL,
    amount DECIMAL(10, 2) DEFAULT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    FOREIGN KEY (scheme_id) REFERENCES Scheme(id)
);

CREATE TABLE Application (
    id CHAR(36) PRIMARY KEY,
    applicant_id CHAR(36) NOT NULL,
    scheme_id CHAR(36) NOT NULL,
    status ENUM('pending', 'approved', 'rejected') DEFAULT 'pending',
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    FOREIGN KEY (applicant_id) REFERENCES Applicant(id),
    FOREIGN KEY (scheme_id) REFERENCES Scheme(id)
);

CREATE TABLE app_user (
    id CHAR(36) PRIMARY KEY,
    username VARCHAR(100) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

CREATE TABLE role (
    id CHAR(36) PRIMARY KEY,
    name VARCHAR(100) UNIQUE NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

CREATE TABLE user_roles (
    id CHAR(36) PRIMARY KEY,
    user_id CHAR(36) NOT NULL,
    role_id CHAR(36) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES app_user(id),
    FOREIGN KEY (role_id) REFERENCES role(id)
);
