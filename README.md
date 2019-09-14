# Serwis do prowadzenia wypożyczalni samochodów

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
- added Privileges [testing];
- fixed ERROR on EmployeeRepository, EmployeeService methods;
- added Orders [testing];

## Changelog v1.2.0
##### 12.09.2019
- Added all models by presentation of project;
- Added CarController and antMatchers in WebSecurityConfig;