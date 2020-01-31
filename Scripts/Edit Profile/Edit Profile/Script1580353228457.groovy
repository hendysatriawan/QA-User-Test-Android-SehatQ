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

Mobile.comment('Story: Edit Profile akun yang login sebelumnya')

//Mobile.comment('definisikan package dari profile')
//def appCom = PathUtil.relativeToAbsolutePath(GlobalVariable.apk, RunConfiguration.getProjectDir())
//
//Mobile.startApplication(appCom, true)
Mobile.comment('run test case login sebelumnya jika belum login, run test case login sebelumnya')

if (Mobile.waitForElementPresent(findTestObject('Home_login_element/Menu - Profile'), GlobalVariable.G_timeout, FailureHandling.OPTIONAL) == 
false) {
    Mobile.closeApplication()

    Mobile.callTestCase(findTestCase('Login/Login'), [:], FailureHandling.STOP_ON_FAILURE)
}

Mobile.comment('Buka halaman profile')

Mobile.waitForElementPresent(findTestObject('Home_login_element/Menu - Profile'), GlobalVariable.G_timeout)

Mobile.tap(findTestObject('Home_login_element/Menu - Profile'), 0)

Mobile.comment('cek halaman profile')

Mobile.waitForElementPresent(findTestObject('Profile_element/text - profile saya'), GlobalVariable.G_timeout)

Mobile.waitForElementPresent(findTestObject('Profile_element/Button - Back to Home'), 0)

Mobile.comment('Lakukan edit profile')

Mobile.waitForElementPresent(findTestObject('Profile_element/Button - Edit Profile'), GlobalVariable.G_timeout)

Mobile.tap(findTestObject('Profile_element/Button - Edit Profile'), 0)

Mobile.comment('cek halaman edit profile')

Mobile.waitForElementPresent(findTestObject('edit_profile_element/Text - edit profile'), 0)

Mobile.comment('upload foto')

Mobile.waitForElementPresent(findTestObject('edit_profile_element/button - edit foto'), GlobalVariable.G_timeout)

Mobile.tap(findTestObject('edit_profile_element/button - edit foto'), 0)

Mobile.waitForElementPresent(findTestObject('edit_profile_element/Text - Galeri'), GlobalVariable.G_timeout)

Mobile.waitForElementPresent(findTestObject('edit_profile_element/Tab - Gambar'), GlobalVariable.G_timeout)

Mobile.waitForElementPresent(findTestObject('edit_profile_element/upload - Gambar 1'), GlobalVariable.G_timeout)

Mobile.tap(findTestObject('edit_profile_element/upload - Gambar 1'), 0)

Mobile.waitForElementPresent(findTestObject('edit_profile_element/Text - edit profile'), GlobalVariable.G_timeout)

Mobile.comment('input Tinggi Badan')

Mobile.waitForElementPresent(findTestObject('edit_profile_element/Input - Tinggi'), GlobalVariable.G_timeout)

Mobile.tap(findTestObject('edit_profile_element/Input - Tinggi'), 0)

not_run: Mobile.clearText(findTestObject('edit_profile_element/Input - Tinggi'), 0)

Mobile.setText(findTestObject('edit_profile_element/Input - Tinggi'), tinggibadan, 0)

Mobile.hideKeyboard()

Mobile.scrollToText('Hemat %s%%', FailureHandling.STOP_ON_FAILURE)

Mobile.delay(2, FailureHandling.STOP_ON_FAILURE)

Mobile.comment('input Berat Badan')

Mobile.waitForElementPresent(findTestObject('edit_profile_element/input - berat'), GlobalVariable.G_timeout)

Mobile.clearText(findTestObject('edit_profile_element/input - berat'), 0)

Mobile.setText(findTestObject('edit_profile_element/input - berat'), beratbadan, 0)

Mobile.comment('input nomor hp')

Mobile.waitForElementPresent(findTestObject('edit_profile_element/input - telpon'), GlobalVariable.G_timeout)

Mobile.clearText(findTestObject('edit_profile_element/input - telpon'), 0)

Mobile.setText(findTestObject('edit_profile_element/input - telpon'), nohp, 0)

Mobile.comment('input alamat')

Mobile.waitForElementPresent(findTestObject('edit_profile_element/input - alamat'), GlobalVariable.G_timeout)

Mobile.clearText(findTestObject('edit_profile_element/input - alamat'), 0)

Mobile.setText(findTestObject('edit_profile_element/input - alamat'), alamat, 0)

Mobile.comment('simpan edit profile')

Mobile.waitForElementPresent(findTestObject('edit_profile_element/Button - edit'), GlobalVariable.G_timeout)

Mobile.tap(findTestObject('edit_profile_element/Button - edit'), 0)

Mobile.comment('cek halaman profile')

Mobile.verifyElementExist(findTestObject('Profile_element/text - profile saya'), GlobalVariable.G_timeout)

Mobile.verifyElementExist(findTestObject('Profile_element/Button - Back to Home'), GlobalVariable.G_timeout)

Mobile.verifyElementExist(findTestObject('Profile_element/Button - Edit Profile'), GlobalVariable.G_timeout)

