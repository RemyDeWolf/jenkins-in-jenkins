import jenkins.model.Jenkins
import hudson.model.*
import java.util.logging.Logger

Logger.global.info("[Running] startup script")

Jenkins.getInstance().disableSecurity()

Jenkins.instance.save()

Logger.global.info("[Done] startup script")
