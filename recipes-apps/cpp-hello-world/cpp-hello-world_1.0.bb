SUMMARY = "Hello World CPP App"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://COPYING;md5=b1d93a883b152536c04eef711a8b4015"

SRC_URI = " \
file://COPYING \
file://cpp-hello-world.cpp \
file://Makefile \
"

S = "${WORKDIR}"

do_install () {
	# Install the binary
	install -m 0755 -d "${D}${bindir}"
	install -m 0755 "${WORKDIR}/cpp-hello-world" "${D}/${bindir}"
}

