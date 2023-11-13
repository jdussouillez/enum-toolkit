# enum-toolkit
Java library to simplify the enum management

## Modules

### Core

Code module

Provides an `EnumUtils` class to manage Java enums easily and using the last Java features (`Optional`, ...).

### Boolean logic

Provides some tools to process some "boolean logic like operations" on enums (`AND`, `XOR`, `NOT`...).

```java
// Enum "ProgramOption" has multiple values: DRY, QUIET, VERBOSE, REGEXP, OUTPUT_JSON, etc
var options = EnumSet.of(ProgramOption.VERBOSE, ProgramOption.REGEXP);
var processor = new BooleanProcessor<>(options);
var expr0 = not(ProgramOption.DRY);
var expr1 = and(
    primitive(ProgramOption.QUIET),
    primitive(ProgramOption.VERBOSE),
    primitive(ProgramOption.DRY)
);
var expr2 = and(
    primitive(ProgramOption.VERBOSE),
    not(ProgramOption.DRY),
    or(
        primitive(ProgramOption.REGEXP),
        primitive(ProgramOption.OUTPUT_JSON)
    )
);
System.out.println("Selected options: " + options);
System.out.println(String.format("expr0: %s => %s", expr0, processor.process(expr0)));
System.out.println(String.format("expr1: %s => %s", expr1, processor.process(expr1)));
System.out.println(String.format("expr2: %s => %s", expr2, processor.process(expr2)));
```

Output :

```
Selected options: [VERBOSE, REGEXP]
expr0: ~DRY => true
expr1: QUIET & VERBOSE & DRY => false
expr2: VERBOSE & (~DRY) & (REGEXP | OUTPUT_JSON) => true
```

*Note: this module exists because I like to play with Java and enums, it's not really useful, has no very good performance and may not be production-ready yet.*

## Contributing

### Environment

- JDK 17+
- Maven 3.8+

### Conventions/tools

- Please respect the code conventions (watch how it's done in the existing code), Checkstyle cannot check everything
- Please respect the ["Convential Commits" specificiation](https://www.conventionalcommits.org/en/v1.0.0/#summary)

## Contributors

- Junior DUSSOUILLEZ
