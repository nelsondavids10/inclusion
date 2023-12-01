# TEST TÉCNICO INCLUSION CLOUD

## Introduction

You are given three integers x,y and n. Your task is to find the maximum integer k such that 0≤k≤n that k mod x = y, where mod is modulo operation. Many programming languages use percent operator % to implement it. In other words, with given x,y and n you need to find the maximum possible nteger from 0 to n that has the remainder y modulo x. You have to answer t independent test cases. It is guaranteed that such k exists for each test case.

Input: The first line of the input contains one integer t (1≤t≤5⋅104) — the number of test cases. The next t lines contain test cases. The only line of the test case contains three integers x,y and n (2≤x≤109; 0≤y<x; y≤n≤109). It can be shown that such k always exists under the given constraints.

Output: For each test case, print the answer — maximum non-negative integer k such that 0≤k≤n and kmodx=y. It is guaranteed that the answer always exists.

Examples:

INPUTS X,Y,N:
* 7 5 12345
* 5 0 4
* 10 5 15
* 17 8 54321
* 499999993 9 1000000000
* 10 5 187
* 2 0 999999999

OUTPUTS:
* 12339
* 0
* 15
* 54306
* 999999995
* 185
* 999999998

## Technologies

* Java 11
* SpringBoot 2.7.16
* Apache-maven-3.6.3
* Swagger OPEN-API V3
* Lombok
* SLF4j

## Installation

Run the following command to install the necessary dependencies of the maven project and run de Unitary Test

```bash
mvn clean install
```

Now run this command to launch the application

```bash
mvn spring-boot:run
```
![image](https://github.com/nelsondavids10/inclusion/assets/64111407/c77e0401-74f2-469a-aff5-047c0fb11389)


## Documentation

After launching the application you can access the documentation by entering the url through the browser: http://localhost:8080/swagger-ui/index.html#/

![image](https://github.com/nelsondavids10/inclusion/assets/64111407/851b59d9-d5e6-4c23-9a01-b0d91df0971c)

## Testing

You can test the GET and POST services of the application using postman as follows:

![image](https://github.com/nelsondavids10/inclusion/assets/64111407/1a76354e-e76c-4577-a92f-3661d8ff4fbd)

![image](https://github.com/nelsondavids10/inclusion/assets/64111407/4a308aa2-5c43-442b-9a44-657658c82edf)

You can import the postman collection from the file: InclusionTest.postman_collection.json: https://github.com/nelsondavids10/inclusion/blob/develop/InclusionTest.postman_collection.json

