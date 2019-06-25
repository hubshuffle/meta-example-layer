PACKAGECONFIG_remove = "networkd resolved backlight"
PACKAGECONFIG_append = " coredump"

FILESEXTRAPATHS_prepend := "${THISDIR}/files:"
SRC_URI += "\
file://timesyncd.conf \
"

do_install_append() {
    # Install the custom conf files on target
    install -m 0644 ${WORKDIR}/timesyncd.conf ${D}${sysconfdir}/systemd

    # enable timesyncd service
    install -d ${D}${sysconfdir}/systemd/system/sysinit.target.wants
    ln -sf ${systemd_unitdir}/system/systemd-timesyncd.service \
            ${D}${sysconfdir}/systemd/system/sysinit.target.wants/systemd-timesyncd.service
}
