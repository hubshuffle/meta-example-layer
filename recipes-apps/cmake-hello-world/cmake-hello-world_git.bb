SUMMARY = "Example recipe using CMake"
DESCRIPTION = "A simple hello world application that uses cmake"
LICENSE = "CLOSED"

BRANCH = "master"
SRCREV = "a8c94614703ed575a26bd8c89c6d440b12355981"
SRC_URI = "git://github.com/hubshuffle/cmake-hello-world.git;protocol=https;branch=${BRANCH}"
SRC_URI[md5sum] = "e8eb199781e2d96fdc3b2cb3d87090d9"


S = "${WORKDIR}/git/"

inherit cmake

do_install() {
    # Install the binary
    install -m 0755 -d "${D}${bindir}"
    install -m 0755 cmake-hello-world-cpp "${D}${bindir}"
}

#RDEPEND_${PN} = "libstdc++"
