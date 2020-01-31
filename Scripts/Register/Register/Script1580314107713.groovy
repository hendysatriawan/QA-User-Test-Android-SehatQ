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
import com.github.javafaker.Faker as Faker		//pastikan sudah ditambahkan .jar nya di external library

Mobile.comment('Story: Register User Baru')

Mobile.comment('Register dengan data dummy (pakai faker)')

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

Mobile.comment('cek halaman register & lakukan register')
Mobile.tap(findTestObject('Login_element/tombol-register'), GlobalVariable.G_timeout)

Mobile.waitForElementPresent(findTestObject('Register_element/Text-Sign Up'), 0)

Mobile.comment('create data dummy dengan faker')
Faker faker = new Faker()

String name = faker.name().firstName()

println(name)

String namadepan = (name + ' ') + 'Test'

String namadepan2 = name + 'Test'

println(namadepan)

GlobalVariable.g_nama = namadepan

println(namadepan2)

String email = namadepan2 + '@yopmail.com'

println(email)

GlobalVariable.g_email = email

Mobile.comment('input nama lengkap')
Mobile.waitForElementPresent(findTestObject('Register_element/InputText-Full Name'), GlobalVariable.G_timeout)

Mobile.setText(findTestObject('Register_element/InputText-Full Name'), namadepan, GlobalVariable.G_timeout)

Mobile.comment('input email')
Mobile.waitForElementPresent(findTestObject('Register_element/InputText-Email'), GlobalVariable.G_timeout)

Mobile.setText(findTestObject('Register_element/InputText-Email'), email, GlobalVariable.G_timeout)

Mobile.comment('input password')
Mobile.waitForElementPresent(findTestObject('Register_element/InputText-Password'), GlobalVariable.G_timeout)

Mobile.setText(findTestObject('Register_element/InputText-Password'), GlobalVariable.G_password, GlobalVariable.G_timeout)

Mobile.comment('check agree')
Mobile.waitForElementPresent(findTestObject('Register_element/Checkbox-Agree'), GlobalVariable.G_timeout)

Mobile.checkElement(findTestObject('Register_element/Checkbox-Agree'), 0)

Mobile.comment('lanjutkan')
Mobile.waitForElementPresent(findTestObject('Register_element/Button-Lanjutkan1'), GlobalVariable.G_timeout)

Mobile.tap(findTestObject('Register_element/Button-Lanjutkan1'), 0)

Mobile.comment('halaman lengkapi profile')
Mobile.waitForElementPresent(findTestObject('register_lengkapi_profile/text-lengkapi profile'), GlobalVariable.G_timeout)

Mobile.comment('pilih tanggal lahir')
Mobile.waitForElementPresent(findTestObject('register_lengkapi_profile/icon-tanggal lahir'), GlobalVariable.G_timeout)

Mobile.tap(findTestObject('register_lengkapi_profile/icon-tanggal lahir'), 0)

Mobile.waitForElementPresent(findTestObject('tanggal_android/text-tahun now'), GlobalVariable.G_timeout)

Mobile.tap(findTestObject('tanggal_android/text-tahun now'), 0)

Mobile.waitForElementPresent(findTestObject('tanggal_android/text-tahun_pilih_1'), GlobalVariable.G_timeout)

Mobile.tap(findTestObject('tanggal_android/text-tahun_pilih_1'), 0)

Mobile.waitForElementPresent(findTestObject('tanggal_android/Button - Ok'), GlobalVariable.G_timeout)

Mobile.tap(findTestObject('tanggal_android/Button - Ok'), 0)

Mobile.comment('pilih jenis kelamin')
Mobile.waitForElementPresent(findTestObject('register_lengkapi_profile/Rb-laki laki'), GlobalVariable.G_timeout)

Mobile.tap(findTestObject('register_lengkapi_profile/Rb-laki laki'), 0)

Mobile.comment('klik lanjut')
Mobile.waitForElementPresent(findTestObject('register_lengkapi_profile/Button - lanjutkan 2'), GlobalVariable.G_timeout)

Mobile.tap(findTestObject('register_lengkapi_profile/Button - lanjutkan 2'), 0)

Mobile.comment('cek berhasil register - harus ada menu profile di footer menu')
Mobile.verifyElementExist(findTestObject('Home_login_element/Menu - Profile'), GlobalVariable.G_timeout)

Mobile.takeScreenshot('register_verify.jpg', FailureHandling.STOP_ON_FAILURE)

//println(GlobalVariable.g_nama)
//
//println(GlobalVariable.g_email)

Mobile.closeApplication()


