## FizjoStudio - application to help organizing Phisioterapist studio

<img src="https://github.com/Furmi37/FizjoStudio/assets/147946906/b111700d-9bd2-4f95-9903-d4cb8a4acdf2" width="300" height="200" />

Fizjostudio is application that was created while I was learning programming. 

### Technologies:
- Java (20.0) - Collections API, File operations, System In/Out
- Maven
- InteliJ IDEA
- JUnit5 

### Features
It is an application which will help to organize as a Phisioterapist. In app you can add patients that will come to you today and you can register them to your service, find them, print their list. They are also saved to document. Every single day is seperated in doc beetwen the lines (every exit of app ends a day and puts line). You have list of patients only added today, but in doc you can see every patient from the begining.

### Requirements
- Java [20]

### How to run app in console:

- In terminal you need to go to directory with project - FizjoStudio,
- You need to go to directories FijzoStudio -> Phisioterapist studio -> src -> com -> furmi,
- Then you need to write in terminal command line first line from below,
- After that write in command line the second line and app should work succesfully
  
Comand Line:
```
furmi % javac -d out data/*.java service/*.java Tools/*.java
furmi % java -cp out com.furmi.service.StudioService
