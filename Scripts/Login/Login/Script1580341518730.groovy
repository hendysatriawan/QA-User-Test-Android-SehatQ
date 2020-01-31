import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.configuration.RunConfiguration as RunConfiguration
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.util.internal.PathUtil as PathUtil
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable

println(GlobalVariable.g_nama)

println(GlobalVariable.g_email)

Mobile.comment('Story: Login dengan User yang sudah terdaftar')

Mobile.comment('definisikan package dari profile')

def appCom = PathUtil.relativeToAbsolutePath(GlobalVariable.apk, RunConfiguration.getProjectDir())

Mobile.startApplication(appCom, true)

Mobile.comment('masuk halaman onboarding & pilih skip')

Mobile.waitForElementPresent(findTestObject('Onboarding_element/text-Sakit apa ya'), GlobalVariable.G_timeout)

Mobile.waitForElementPresent(findTestObject('Onboarding_element/text - Skip'), GlobalVariable.G_timeout)

Mobile.tap(findTestObject('Onboarding_element/text - Skip'), GlobalVariable.G_timeout)

Mobile.comment('cek halaman home')

Mobile.waitForElementPresent(findTestObject('Home_element/fitur-lainnya'), GlobalVariable.G_timeout)

Mobile.waitForElementPresent(findTestObject('Home_element/Menu-Home'), GlobalVariable.G_timeout)

Mobile.comment('masuk ke halaman login')

Mobile.waitForElementPresent(findTestObject('Home_element/Menu-Login'), GlobalVariable.G_timeout)

Mobile.tap(findTestObject('Home_element/Menu-Login'), GlobalVariable.G_timeout)

Mobile.comment('cek halaman login')

Mobile.waitForElementPresent(findTestObject('Login_element/Login-Email'), GlobalVariable.G_timeout)

Mobile.tap(findTestObject('Login_element/Login-Email'), GlobalVariable.G_timeout)

Mobile.comment('cek halaman input login')

Mobile.waitForElementPresent(findTestObject('Login_element/Text-Login'), GlobalVariable.G_timeout)

Mobile.waitForElementPresent(findTestObject('Login_element/tombol-register'), GlobalVariable.G_timeout)

Mobile.comment('input username & password lalu klik lanjutkan')

Mobile.setText(findTestObject('Login_element/InputText-EmailUsername'), GlobalVariable.g_email, 0)

Mobile.waitForElementPresent(findTestObject('Login_element/InputText-Password'), GlobalVariable.G_timeout)

Mobile.setText(findTestObject('Login_element/InputText-Password'), GlobalVariable.G_password, 0)

Mobile.waitForElementPresent(findTestObject('Login_element/Button-Lanjutkan'), GlobalVariable.G_timeout)

Mobile.tap(findTestObject('Login_element/Button-Lanjutkan'), 0)

Mobile.comment('cek halaman home setelah berhasil login')

Mobile.waitForElementPresent(findTestObject('Home_login_element/Menu - Home'), GlobalVariable.G_timeout)

Mobile.verifyElementExist(findTestObject('Home_login_element/Menu - Profile'), GlobalVariable.G_timeout)

