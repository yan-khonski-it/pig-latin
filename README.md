# Pig Latin Task

## Requirements
Write some Java code that translates a string (word, sentence, or paragraph) into “pig-latin” using the
following rules.

- Words that start with a consonant have their first letter moved to the end of the word and the
letters “ay” added to the end.
   - Hello becomes Ellohay

- Words that start with a vowel have the letters “way” added to the end.
   - apple becomes appleway

- Words that end in “way” are not modified.
   - stairway stays as stairway

- Punctuation must remain in the same relative place from the end of the word.
   - can’t becomes antca’y
   - end. becomes endway.

- Hyphens are treated as two words
   - this-thing becomes histay-hingtay

- Capitalization must remain in the same place.
   - Beach becomes Eachbay
   - McCloud becomes CcLoudmay


## How to run
##### 1) You need java 8 or above. You need maven 3

##### 2) Build with maven
`mvn clean install`

##### 3) Run the app in the console

`java -jar ./target/pig-latin-jar-with-dependencies.jar`


## Limitations
Due to limited task description with limited number of examples, I made a reduced version of pig translator.

In real world, if an application gets successful and used by users,
new features can be added after the MVP was released.
This project is such MVP demo showing of basic features of pig translator.

In the future (assuming users will use our application), there will be feature requests with improvements.

- It works only with the English language.
Words that start with non vowel and non consonant (in English) are not translated.

- Diacritics and non-English characters are not supported: words without English letters are not translated.
For example, the word **`приветč`** is not translated and left as is.

https://grammar.yourdictionary.com/punctuation/what/fourteen-punctuation-marks.html

## Technical limitations
I did not optimize anything because there is a rule - before optimization comes profiling.
My task was not to over-engineer things, so I kept my code simple and easy to read.
