FILESEXTRAPATHS_prepend := "${THISDIR}/files:"
SRC_URI += "\
file://journald.conf \
file://system.conf \
"

do_install_append() {
    # Install the custom conf files on target
    install -m 0644 ${WORKDIR}/journald.conf ${D}${sysconfdir}/systemd
    install -m 0644 ${WORKDIR}/system.conf ${D}${sysconfdir}/systemd
}
