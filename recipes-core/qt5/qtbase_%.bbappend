# Customise the qtbase configuration
PACKAGECONFIG_append = " gl directfb eglfs gles2 journald"

# Set the QPA platform
FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

SRC_URI += "\
file://qt-qpa.sh \
"

do_install_append() {
  install -d "${D}${sysconfdir}/profile.d"
  install -m 0644 "${WORKDIR}/qt-qpa.sh" "${D}${sysconfdir}/profile.d/"
}
