import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

'step 3'
WebUI.selectOptionByValue(findTestObject('TC-02-Make Appointment/Combo-Box_Facility'), facility, true)

//WebUI.check(findTestObject('TC-02-Make Appointment/Ceklis-Box_hospital readmisshion'))
'step 4'
if (readmission == true) {
    WebUI.check(findTestObject('TC-02-Make Appointment/Ceklis-Box_hospital readmisshion'))
}

//WebUI.click(findTestObject('Object Repository/TC-02-Make Appointment/Radio_Button_Medicaid_programs'))
'step 5'
def select_radio = healthcareprogram

switch (select_radio) {
    case select_radio = 'Medicare':
        println(select_radio)

        WebUI.click(findTestObject('Object Repository/TC-02-Make Appointment/Radio_Button_Medicare_programs'))

        break
    case select_radio = 'Medicaid':
        println(select_radio)

        WebUI.click(findTestObject('Object Repository/TC-02-Make Appointment/Radio_Button_Medicaid_programs'))

        break
    case select_radio = 'None':
        println(select_radio)

        WebUI.click(findTestObject('Object Repository/TC-02-Make Appointment/Radio_Button_None_programs'))

        break
    default:
        println(select_radio)

        WebUI.click(findTestObject('Object Repository/TC-02-Make Appointment/Radio_Button_None_programs'))}

WebUI.setText(findTestObject('TC-02-Make Appointment/Input_Visit Date (Required)_visit_date'), date)

WebUI.setText(findTestObject('Object Repository/TC-02-Make Appointment/textarea_Comment'), comment)

WebUI.click(findTestObject('Object Repository/TC-02-Make Appointment/Button-Book Appointment'))

WebUI.delay(5)

WebUI.verifyElementVisible(findTestObject('makeappoinment/h2_Appointment Confirmation'))

WebUI.verifyElementText(findTestObject('makeappoinment/p_facility'), facility)

//WebUI.verifyElementText(findTestObject('makeappoinment/p_Healthcare Program'), healthcareprogram)
'step10'
switch (select_radio) {
    case select_radio = 'Medicare':
        println(select_radio)

        WebUI.verifyElementText(findTestObject('makeappoinment/p_Healthcare Program'), 'Medicare')

        break
    case select_radio = 'Medicaid':
        println(select_radio)

        WebUI.verifyElementText(findTestObject('makeappoinment/p_Healthcare Program'), 'Medicaid')

        break
    case select_radio = 'None':
        println(select_radio)

        WebUI.verifyElementText(findTestObject('makeappoinment/p_Healthcare Program'), 'None')

        break
    default:
        println(select_radio)

        WebUI.verifyElementText(findTestObject('makeappoinment/p_Healthcare Program'), 'None')}

//WebUI.verifyElementText(findTestObject('makeappoinment/p_Yes'), readmission)
'step 11'
if (readmission == true) {
    WebUI.verifyElementText(findTestObject('makeappoinment/p_Yes'), 'Yes')
} else {
    WebUI.verifyElementText(findTestObject('makeappoinment/p_Yes'), 'No')
}

WebUI.verifyElementText(findTestObject('makeappoinment/p_comment'), comment)

