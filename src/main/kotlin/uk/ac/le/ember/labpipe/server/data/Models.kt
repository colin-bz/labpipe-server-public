package uk.ac.le.ember.labpipe.server.data

import com.fasterxml.jackson.annotation.JsonProperty
import java.nio.file.Paths

data class LPConfig(var serverPort: Int = 4567) {
    var tempPath: String = Paths.get(System.getProperty("user.home"), "labpipe").toString()
    var dbHost: String = "localhost"
    var dbPort: Int = 27017
    var dbName: String = "labpipe-dev"
    var dbUser: String? = null
    var dbPass: String? = null

    var emailHost: String = "localhost"
    var emailPort: Int = 25
    var emailUser: String? = null
    var emailPass: String? = null

    var notificationEmailName: String = "LabPipe Notification"
    var notificationEmailAddress: String = "no-reply@labpipe.org"

    var debugMode: Boolean = false
}

data class Parameter(@JsonProperty("param_name") var name: String) {
    @JsonProperty("param_value")
    var value: List<Any> = mutableListOf()
}

data class CodeName(var code: String, var name: String)

data class Operator(@JsonProperty("email") var email: String) {
    var name: String = ""
    var username: String = ""

    @JsonProperty("passhash")
    var passwordHash: String = ""


    @JsonProperty("isActive")
    var active: Boolean = false

    var projects: List<String> = mutableListOf()

    @JsonProperty("notification_group")
    var notificationGroup: List<String> = mutableListOf()

    var roles: List<String> = mutableListOf()
}

data class AccessToken(
    var token: String,
    @JsonProperty("keyhash") var keyHash: String
) {
    var roles: List<String> = mutableListOf()
}

data class Location(var code: String, var name: String) {
    var type: List<String> = mutableListOf()
}

data class OperatorRole(val code: String, val name: String)

data class ApiRoleAssign(var url: String, var roles: List<String>)

data class FormTemplate(var code: String, var name: String) {
    @JsonProperty("study_code")
    var studyCode: String = ""

    @JsonProperty("instrument_code")
    var instrumentCode: String = ""

    var template: WizardTemplate = WizardTemplate("Default Wizard Template")
    var url: String? = null

    @JsonProperty("notification_style")
    var notificationStyle: String = "all"

    @JsonProperty("notification_subject")
    var notificationSubject: String = ""
}

data class ElectronFileFilter(var name: String) {
    var extensions: List<String> = mutableListOf()
}

data class QuestionTemplate(var key: String, var label: String, var controlType: String) {
    var required: Boolean = true
    var order: Int = 1
    var type: String? = null
    var pattern: String? = null
    var options: String = ""
    var helperText: String = ""
    var target: String? = null
    var multiple: Boolean = false
    var filter: List<ElectronFileFilter> = mutableListOf()
}

data class WizardPageFormValidProcess(var processType: String, var dataField: String) {
    var newField: String? = null
}

data class WizardPageTemplate(var key: String, var title: String) {
    var navTitle: String? = ""
    var requireValidForm: Boolean = true
    var order: Int = 1
    var questions: List<QuestionTemplate> = mutableListOf()
    var formValidProcess: List<WizardPageFormValidProcess> = mutableListOf()
}

data class WizardTemplate(var title: String) {
    var pages: List<WizardPageTemplate> = mutableListOf()
}

data class EmailGroup(var code: String) {
    var name: String = ""

    @JsonProperty("study_code")
    var studyCode: String = ""

    @JsonProperty("form_code")
    var formCode: String = ""

    var admin: List<String> = mutableListOf()
    var member: List<String> = mutableListOf()
}


