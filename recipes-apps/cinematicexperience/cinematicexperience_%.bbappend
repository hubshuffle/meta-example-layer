FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

SRC_URI += "\
file://cinematicexperience.service \
"

inherit systemd

do_install_append() {
  # Install service
  install -m 0755 -d "${D}${systemd_unitdir}/system"
  install -m 0644 "${WORKDIR}/cinematicexperience.service" "${D}${systemd_unitdir}/system/"
}

FILES_${PN} += "\
${systemd_unitdir}/system/cinematicexperience.service \
"

SYSTEMD_SERVICE_${PN} = "cinematicexperience.service"

