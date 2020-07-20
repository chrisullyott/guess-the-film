# 🎥 ✨ Guess the film!

Like Hangman, but less risky. A quick project from Udacity's [Object Oriented Programming in Java](https://www.udacity.com/course/object-oriented-programming-in-java--ud283).

### How to run?

Compile the Java program and then run.

```bash
$ javac GuessTheFilm.java && java GuessTheFilm;
```

### How to play?

Guess one or several characters at a time.

```bash
**Guess the film!**
_______ __ ___ ____ ___
```

Entering `Letter: aie` ...


```bash
**Guess the film!**
_AI_E__ __ __E ____ A__
```

Entering `Letter: bcdr` ...

```bash
**Guess the film!**
RAIDER_ __ __E ____ AR_
Wrong: 2 of 7 [B, C]
Letter:
```

Entering `Letter: raiders of the lost ark`

```bash
**Guess the film!**
RAIDERS OF THE LOST ARK
Wrong: 2 of 7 [B, C]
Correct!
The answer is: RAIDERS OF THE LOST ARK
```

