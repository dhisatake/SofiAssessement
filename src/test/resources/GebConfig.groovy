import org.openqa.selenium.UnexpectedAlertBehaviour
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeOptions
import org.openqa.selenium.remote.CapabilityType
import org.openqa.selenium.remote.DesiredCapabilities


driver ={

            ChromeOptions options = new ChromeOptions()
            options.addArguments("--start-maximized")
            options.addArguments("--incognito")
            DesiredCapabilities capabilities = new DesiredCapabilities()
            capabilities.setCapability(ChromeOptions.CAPABILITY, options)
            capabilities.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.ACCEPT)
            new ChromeDriver(capabilities)
        }
