package hudson.model.UsageStatistics

import hudson.model.UsageStatistics
import jenkins.security.FIPS140
import hudson.Functions

def f=namespace(lib.FormTagLib)

f.section(title: _("Usage Statistics")) {
    if (UsageStatistics.DISABLED) {
        span(class: "jenkins-not-applicable") {
            raw(_("disabledBySystemProperty"))
        }
    } else if (FIPS140.useCompliantAlgorithms()) {
        f.optionalBlock(field: "usageStatisticsCollected", checked: app.usageStatisticsCollected, title: _("statsBlurbFIPS"))
    } else {
        f.optionalBlock(field: "usageStatisticsCollected", checked: app.usageStatisticsCollected, title: _("statsBlurb"))
    }
}
