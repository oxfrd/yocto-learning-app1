python do_generate_info() {
    pn = d.getVar('PN')
    pv = d.getVar('PV')
    bpn = d.getVar('BPN')
    buildhost = d.getVar('BUILDHOST')
    target_arch = d.getVar('TARGET_ARCH')
    s_dir = d.getVar('S')
    workdir = d.getVar('WORKDIR')

    bb.plain(f"/*********** Build Info *********************************************************")
    bb.plain(f"*")
    bb.plain(f"* Project name: {pn}\n* Version: {pv}\n* Base Package Name: {bpn}\n* Buildhost: {buildhost}\n* target_arch: {target_arch}")
    bb.plain(f"*")
    bb.plain(f"/********************************************************************************")
}

addtask do_generate_info after do_compile before do_install