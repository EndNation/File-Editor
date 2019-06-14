# File-Editor
File-Editor is a library made by TheDarkSid3r (EndNation) to make reading content of Files and writing to files hopefully more easier.

Built with [JSON-java](https://github.com/stleary/JSON-java). Built with the idea of making file editing more easier, specially for those who are inexperienced.

## Installation

Currently not available.

## Examples

#### Writing To File:
```java
/**
* Writes content to the file provided in filePathString
*
* @param filePathString - Path of file
* @param content - Content to be written in file
*/
public void writeToFile(String filePathString, String content) throws IOException
{
  FileEditor fe = new FileEditor();
  
  fe.writeToFile(filePathString, content);
}
```

#### Read file content:
```java
/**
* Reads the content of file specified
* 
* @param filePathString - Path of file
* @return content of file
* @throws IOException 
*/
public String readFile(String filePathString) throws IOException
{
  FileEditor fe = new FileEditor();
  
  return fe.readFile(filePathString);
}
```

## Feedbacks

Got any suggestions or feedbacks? You can always make a pull-request if you can code the idea out. If you can't code, worry not, I will be coming up with ways you can give suggestions.
