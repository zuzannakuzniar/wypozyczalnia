# Serwis do prowadzenia wypożyczalni samochodów 
Ilość moich commitów w tym projekcie jest mała, ponieważ rzadziej je robiłam.

## Changelog v1.0
##### 10.09.2019
- reworked connection to database from H2 to MySql;
- added WebSecurityConfig;
- added priveleges for USER and ADMIN roles;
- added UserController;
- Segregated project files;
- added "dto" for Users;
- added fetching @ManyToOne to dto.

## Changelog v1.1.0
##### 11.09.2019
- Added Role: PRACOWNIK, MANAGER;
- added Colors;
- upgraded Status, Car, User;
- added Privileges;
- fixed ERROR on EmployeeRepository, EmployeeService methods;
- added Orders;

## Changelog v1.2.0
##### 12.09.2019
- Added all models by presentation of project;
- Added CarController and antMatchers in WebSecurityConfig;

## Changelog v1.3.0
##### 14.09.2019
- Added all Services, Repositories and Controllers;
- Fixed all Controllers (problem with endPoints);
- Added reference in Address, User, Department and Rental;
- Added Swagger;

##Changelog v1.4.0
##### 15.09.2019
- upgraded springboot from 2.0.4 to 2.1.8
