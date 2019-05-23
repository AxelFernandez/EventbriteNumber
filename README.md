# Eventbrite Number

_This project is a game for Eventbrite. The game ends when the Computer guess you number or you guess the number what Computer thinks_

## Starting 🚀

First, you must take an opcion to select:

### 1-Human vs PC:
In this opcion the Pc think a four cifres number and you must try until found it.
The Computer return you two values.

Good and Regular.

```
1 Good 1 Regular 

//1 Good means cifres you try is in the correct position and correct value
//1 Regular means cifres you try is the correct value, but in the wrong position
```

### 2- Pc vs Human

In this option, you think a number and the Pc try to guess it.

The computer try to figure out, and it try a first number.

```
Write a number with four digit, and no repeat it
2468    //This is you secret number!
We try 3504 and we recommend this from the number 2468
0 Good 1 Regular
```
We analyze the number and recommend a answer to return.
The Computer will keep trying until figure out the number.

You can disable this participation and look how the algotyrthm solves the problem if yoy comment this line in HumanPcStrategy.

```
  /**
     * Validate if the number generated is correct
     * @return true if is correct, and the game over.
     */
    @Override
    public boolean isResult() {
       if (!isresult){
           String responseCheck= attempt.get(0) +","+attempt.get(1);
           System.out.println("We try "+ tryNumber.getSecretNumber()+" and we recommend this from the number "+ secretNumber.getSecretNumber());
           System.out.println(attempt.get(0)+" Good "+attempt.get(1)+" Regular");
           System.out.println("Type "+responseCheck);
          // AnswerCheck(responseCheck); <------------Comment this line
           System.out.println("-----------------------------------------------------");
       }else {
           System.out.println("I Win!");
       }
       return isresult;
    }
```


## Build with 🛠️

* [Junit](https://junit.org/junit5/) - Used for Test


## Author ✒️


* **Axel Fernandez** - *Developer* - [LinkedIn](https://www.linkedin.com/in/axel-fernandez/)

---
⌨️ con ❤️ por [Axel Fernandez](https://github.com/AxelFernandez) 😊
