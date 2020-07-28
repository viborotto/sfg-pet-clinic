# sfg-pet-clinic
Main Project in Course Spring Framework 5: Beginner to Guru

Notes about course
Consolide Concepts for consult:

#### Exception Handling in Spring MVC
    Recap HTTP Status:
        5xx Server Error
            500 : generally any unhandled exception
        4xx Client Errors - Generally Checked Exceptions
            400 Bad Request : Cannot process due to client error
            401 Unauthorized : Authentication required
            404 Not Found : Resource not found
            405 Method Not Allowed : HTTP method not allowed
            409 Conflict : Possible with simultaneous updates
            417 Expectation Failed : Sometimes used with RESTful interfaces 
            418 I'm a Teapot : April Fools Joke from IETF(Internet Engineering Task Force) in 1998
            
@ResponseStatus:
    It allows annotate a custom exception class with the HTTP status that we want returned and this is going thow.

@ExceptionHandler:
    Works at the controller level
    Allows you to define custom exception handling
        Can be used with @ResponseStatus for just returning HTTP status
        Can be used to return a specific view
        Also can take total control and work with Model and View
            Model cannot be a parameter of an Exception Handler method

HandlerExceptionResolver
    Is an interface you can implement for custom exception handling 
    USed Internally by Spring MVC
    Note Model is not passed
    
Internal Spring MVC Exeption Handlers
    Spring MVC has 3 implementations of HandlerExceptionResolver
    ExceptionHandlerExceptionResolver - Matches uncaught exeptions to @ExceptionHandler
    ResponseStatusExceptionResolver - Looks for uncaught exceptions matching @ResponseStatus
    DefaultHandlerExceptionResolver - Convert standard Spring Exceptions to HTTP status codes
    
Custom HandlerExceptionResolver
    You can provide your own implementations of HandlerExceptionResolver
    Typically implemented with Spring Ordered interface to define order the handle will run in 
    Custom implementations are uncommon due to Spring robust exception handling

SimpleMappingExceptionResolver
    A Spring Bean you can define to map exceptions to specific views
    You only define the exception class name and the view name
    You can optionally define a default error page
    
    Which to Use When?
    If just the HTTP status @ResponseStatus
    If redirection to a view use SimpleMappingExceptionResolver
    If both consider @ExceptionHandler on the controller
    
    Global Handler : @ControllerAdvice
    
#### Data Validation

JSR-303 | Java Bean Validation
      
      Set of annotation used to validate Java bean properties
      
Data validation with Spring MVC

      Built In Constraints Definitions
      @Null - Checks value is null
      @NotNull - Checks value is not null
      @AssertTrue - Value is true
      @AssertFalse - Value is false
      @Min - Number is equal or higher
      @Max - Number is equal or less
      @DecimalMin - Value is larger
      @DecimalMax - Value is less than
      @Negative - Value is greater than zero. Zero invalid
      @NegativeOrZero - Value is zero or less than zero
      @Positive - Value is greater than zero. Zero invalid
      @PositiveOrZero - Value is zero or greater than zero
      @Size - Checks
      @Digits - Checks for integer digits and fraction digits
      @Past - Checks if date is in past
      @PastOrPresent - Checks if date is in past or present
      @Future - Checks if date is in future
      @FutureOrPresent - Checks if date is present or in future
      @Pattern - checks gainst  RegEx patter
      @NotEmpty - Checks if value is null or empty(whitespace charaters or empty collection)
      @NonBlank - Checks string is not null or not whitespace characters
      @Email - Checks if String value is an email address
      
      Hibernate Validator Constraints
      @ScriptAssert - Class level annotation, checks class against script
      @CreditCardNumber - Verifies value is a credit card number
      @Currency - Valid currency amount
      @DurationMax - Duration less than given value
      @DurationMin - Duration greater than given value
      @EAN - Valid EAN barcode
      @ISBN - Valid ISBN value
      @Length - String length between given min and max
      @CodePointLength - Validates that code point length of the annotated character sequence is between min and max included
      @LuhnCheck - Luhn check sum
      @Mod1OCheck - Mod 10 check sum
      @Mod11Check - Mod 11 check sum
      @Range - Checks if number is between given min and max(inclusive)
      @SafeHtml - Checks for safe HTML
      @UniqueElements - Checks if collection has unique elements
      @Url - checks for valid URL
      @CNPJ - Brazilian Corporate Taxpayer Registry Number
      @CPF - Brazilian Individual Taxpayer Registry Number
      @TituloEleitoral - Brazilian voter ID
      @NIP - Polish VAR ID
      @PESEL - Polish National Validation Number
      @REGON - Polish Taxpayer ID
      
 Data validation with thymeleaf[soon]
 
 #### Internacionalization  - I18N
 
 Fairly broad topic: languages, currancies, layouts
 In Spring MVC context generally is looking at support for languages
 Driven by accept-language request header
 en-US, en is the language code, US is the country code
 
 
 Local Detection: default behavior is to use Accept-Language header, can be configured to use system, a cookie, or a custom parameter(is useful to allow user to select language)
 
 
 Locale Resolver: AcceptHeaderLocaleResolver is the SpringBoot Default, optionaly, can use FixedLocaleResolver(uses the locale of the JVM), available: CookieLocaleResolver and SessionLocaleResolver
 
 
 Changing Locale: browsers are typically tied to the Locale of OS, locale changing plugins are available, spring MVC provide as LocaleChangeInterceptor to allow you to configure a custom parameter to use to change the locale
 
 
 Resource Bundles: messages.properties are selected on highest match order, first selected will be on language region, i.e messages_en_US.properties, if no exact match is found just the language code is used
 
 
 ->Spring MVC Internationalization
 
 
 
 
 
 
