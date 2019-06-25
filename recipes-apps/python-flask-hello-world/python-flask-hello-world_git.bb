# Recipe created by recipetool
# This is the basis of a recipe and may need further editing in order to be fully functional.
LICENSE = "CLOSED"
LIC_FILES_CHKSUM = ""

BRANCH="master"
SRC_URI = " \
  git://github.com/hubshuffle/python-flask-hello-world.git;protocol=https;branch=${BRANCH} \
  file://flask-hello-world.service \
  file://0001-example.patch;md5=e97e332d5a43c33cf29a2ee1662d25f1 \
"

S = "${WORKDIR}/git"

inherit systemd

# Modify these as desired
PV = "0.1+git${SRCPV}"
SRCREV = "ef935ecdf7b081fbc86ae9a71812e64a6a138301"

RDEPENDS_${PN} = "python3 python3-flask"

do_install () {
    # Install the python script
    install -m 0755 -d "${D}${bindir}"
    install -m 0755 app.py "${D}${bindir}"
    
    # Install service
    install -m 0755 -d "${D}${systemd_unitdir}/system/"
    install -m 0644 "${WORKDIR}/flask-hello-world.service" "${D}${systemd_unitdir}/system/"
}

FILES_${PN} += " \
  ${bindir}/app.py \
  ${systemd_unitdir}/system/flask-hello-world.service \
"

SYSTEMD_SERVICE_${PN} = "flask-hello-world.service"
