# KaplanAutomation
This is a Java-based Selenium TestNG framework that automates the following test cases:

## DemoQA Test cases:
- Nested Frames
- Alerts
- Drag and Drop
- Browser Windows
## Flipkart Test cases:
- Hover on the Fashion section.
- Hover on the Kids subsection and click on "Boys & Girls Jeans".
- Select the Price-Low to High in the Sort By section.
- Click on any items displayed.
- Get the price of the item and name of the item.
- Fill all the required fields and add the item to the cart.
- Verify the price and name of the item in the checkout page matches with the one we had before adding the item.

### How to Run
**1. Clone the repository:** git clone https://github.com/PJeevitha/KaplanAutomation.git

**2. Open the project in IntelliJ:** File → New → Project from Version Control → Git → Paste the repo link

**3. Set Java SDK:** File → Project Structure → Project SDK → Select Java 8 or 11

**4. Keep your ChromeDriver in this path:** "C:\\Drivers\\chromedriver.exe"

**5. To run DemoQA tests, run this testNG:** testng-demoQA.xml

**6. To run Flipkart automation tests, run this testNG:** testng-flipkart.xml
