# KaplanAutomation
This is a Java-based Selenium TestNG framework that automates the following test cases:

## DemoQA Tests:
- Nested Frames
- Alerts
- Drag and Drop
- Browser Windows
## Flipkart Test:
- Hover on the Fashion section.
- Hover on the Kids subsection and click on "Boys & Girls Jeans".
- Select the Price-Low to High in the Sort By section.
- Click on any items displayed.
- Get the price of the item and name of the item.
- Fill all the required fields and add the item to the cart.
- Verify the price and name of the item in the checkout page matches with the one we had before adding the item.

### How to Run
Requirements: 
- Java JDK
- Maven
- Chrome browser
- ChromeDriver placed here "C:\\Drivers\\chromedriver.exe"
  
1. Install Java and Maven
2. Clone this repo: git clone https://github.com/PJeevitha/KaplanAutomation.git
3. Navigate to the project directory: cd KaplanAutomation
4. Run tests with: mvn clean test
5. To run a specific suite:
   - mvn clean test -DsuiteXmlFile=testng-demoQA.xml
   - mvn clean test -DsuiteXmlFile=testng-flipkart.xml
