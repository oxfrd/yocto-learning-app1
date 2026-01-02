DESCRIPTION = "Nudoku is a terminal based Sudoku game with a graphical interface using ncurses and cairo."
HOMEPAGE = "https://github.com/jubalh/nudoku"
SECTION = "games"
SUMMARY = "Terminal based Sudoku game with graphical interface"
AUTHOR = "Jubal Harp <jubalh@gmail.com>"

LICENSE = "GPL-3.0-only"
LIC_FILES_CHKSUM = "file://LICENSE;md5=d32239bcb673463ab874e80d47fae504"

SRC_URI = "https://github.com/jubalh/nudoku/archive/refs/tags/${PV}.tar.gz"
SRC_URI[sha256sum] = "ba60a99c9832b5c950a00a0a9d1e0938fddf2cef32765bca18041e770afc3c4a"

DEPENDS = "ncurses cairo"

inherit pkgconfig gettext autotools kurs

EXTRA_OECONF = ""

CFLAGS:append = "${@bb.utils.contains('ENABLE_UART', '1', ' -Wextra', '', d)}"

INSTALL_EXTRA_CONFIG = "${@bb.utils.contains('EXTRA_CONFIG', '1', 'yes', 'no', d)}"

do_install:append() {
    if [ "${INSTALL_EXTRA_CONFIG}" = "yes" ] ; then
        install -d ${D}${sysconfdir}/nudoku2
        install -m 0644 ${S}/README.md ${D}${sysconfdir}/nudoku2/README.md
    fi
}