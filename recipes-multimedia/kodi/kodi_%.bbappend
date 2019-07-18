FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

SRC_URI += "\
file://0001-cmake-fix-ninja-generator-when-dupbuild-err.patch \
"

WINDOWSYSTEM = "raspberrypi"
ARM_INSTRUCTION_SET = "arm"
do_package_qa[noexec] = "1"
