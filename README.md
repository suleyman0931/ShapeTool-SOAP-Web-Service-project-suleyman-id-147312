# ShapeTool SOAP Web Service

## Overview

ShapeTool is a SOAP-based web service that calculates the area of different geometric shapes.  
It was built using a **contract-first approach**, where the XML Schema (XSD) was designed first and used as the basis for the web service contract.

The service supports five operations:

- `circleArea`
- `squareArea`
- `rectangleArea`
- `parallelogramArea`
- `triangleArea`

Each operation accepts only the required parameters and returns a structured SOAP response with the calculated area.

---

## Features

- SOAP web service built with Spring Boot
- Contract-first design using XSD
- WSDL-based service contract
- Request validation using XSD
- SOAP Fault handling for invalid input
- Supports five geometric shape calculations
- Tested using SoapUI
- Includes sample SOAP request/response messages

---

## Service Operations

### circleArea
Calculates the area of a circle:


Area = π × radius²


---

### squareArea
Calculates the area of a square:


Area = side × side


---

### rectangleArea
Calculates the area of a rectangle:


Area = length × width


---

### parallelogramArea
Calculates the area of a parallelogram:


Area = base × height


---

### triangleArea
Calculates the area of a triangle:


Area = 0.5 × base × height


---


## Project Structure


- src/main/java
- src/main/resources/schemas/shapes.xsd
- samples/requests.xml
- README.md


---

## Namespace

The service uses the following namespace:


http://www.shapetool.com/gen


---

## WSDL and Endpoint

WSDL URL:


http://localhost:8080/ws/shapes.wsdl


SOAP Endpoint:


http://localhost:8080/ws


---

## Validation

Input validation is handled using the XSD schema and Spring Web Services.

The schema ensures:
- valid data types
- required fields
- no negative values

Invalid requests result in a **SOAP Fault response**.

---

## Testing

The service was tested using **SoapUI**.

### Test Cases

- Valid circle request
- Valid square request
- Valid rectangle request
- Valid parallelogram request
- Valid triangle request
- Invalid request (negative input)

---

## Sample Requests and Responses

Available in:


samples/requests.xml


---



---

## How to Run

1. Start the Spring Boot application
2. Open the WSDL in a browser:

http://localhost:8080/ws/shapes.wsdl

3. Import into SoapUI
4. Send SOAP requests
5. Verify responses and SOAP Faults

---

## Conclusion

ShapeTool demonstrates a complete contract-first SOAP web service solution for geometric area calculation.  
It shows practical use of XSD, WSDL, validation, and SOAP communication in a clean and structured way.