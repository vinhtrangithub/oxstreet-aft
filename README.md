# OXSTREET AUTOMATION TEST

## 1. Software required:
* Jdk 1.8
* Maven 3.8.1

## 2. APPLICATION UNDER TEST 
* URL: https://oxstreet.com/
* Programming Language: Java
* Automation Framework: Serenity - Jbase

## 3. Overview
Build automation tests to validate the search page on oxstreet.com. Your automation test should:
1. Go to oxstreet.com
2. Sign in as a user
3. Search for “neptune blue”
4. Validate that product “KAWS x sacai x Blazer Low 'Neptune Blue'” exists on the first page


##  4. How to run
* run with default environment ()
$ mvn clean verify

* run with specific environment
$ mvn clean verify -Denvironment={env}

## 5. The report
After running, the report will be generated in under the path "target\site\serenity\index.html"