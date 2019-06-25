FILESEXTRAPATHS_prepend := "${THISDIR}/files:"
SRC_URI += "\
file://home-wifi.nmconnection \
"

do_install_append() {
    # Install "home wifi" connection config
    install -m 0600 ${WORKDIR}/home-wifi.nmconnection ${D}${sysconfdir}/NetworkManager/system-connections
}
