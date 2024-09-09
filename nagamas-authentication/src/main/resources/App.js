import React, { Component } from 'react';
import { BrowserRouter as Router, Route, NavLink, HashRouter } from 'react-router-dom';
import { connect } from 'react-redux';
import * as R from 'ramda';

import NotifPopup from '../modules/popup/Notif';
import ProfilePopup from '../modules/popup/Profile';
import logoProhace from '../assets/img/logo-prohace.png'

// auth
import Login from './auth/Index';

// home
import DashboardEmployee from './dashboard/newDashboard/dashboardEmployee'


//masterdata
import User from './masterData/user/user/user'

// icon
var angle = 'fa fa-lg fa-angle-right';
var close = 'fa fa-lg fa-times';

// sub menu
var opSubMenu = 'app-menu app-submenu-themes app-submenu';
var clSubMenu = 'app-menu app-submenu-themes';

var opMenu = 'list';
var clMenu = 'list active';

class App extends Component {
  constructor() {
    super();
    this.state = {
      appClass: 'app', //app-side-big-icon
      appButtonClass: 'fa fa-lg fa-times',
      travelClass: opMenu,
      travelSubmenu: opSubMenu,
      travelMoreIcon: angle,
      timeClass: opMenu,
      timeSubmenu: opSubMenu,
      timeMoreIcon: angle,
      leaveClass: opMenu,
      leaveSubmenu: opSubMenu,
      leaveMoreIcon: angle,
      overtimeClass: opMenu,
      overtimeSubmenu: opSubMenu,
      overtimeMoreIcon: angle,
      employeeClass: opMenu,
      employeeSubmenu: opSubMenu,
      employeeMoreIcon: angle,

      privilegeReady: false,
      lastMenuData: "",
      menuData: [],
    };
  }

  opEmployeeSubmenu = () => {
    if (this.state.employeeClass === opMenu) {
      this.setState({ employeeSubmenu: clSubMenu });
      this.setState({ employeeClass: clMenu });
      this.setState({ employeeMoreIcon: close });
    } else {
      this.setState({ employeeSubmenu: opSubMenu });
      this.setState({ employeeClass: opMenu });
      this.setState({ employeeMoreIcon: angle });
    }
  };

  opTravelSubmenu = () => {
    if (this.state.travelClass === opMenu) {
      this.setState({ travelSubmenu: clSubMenu });
      this.setState({ travelClass: clMenu });
      this.setState({ travelMoreIcon: close });
    } else {
      this.setState({ travelSubmenu: opSubMenu });
      this.setState({ travelClass: opMenu });
      this.setState({ travelMoreIcon: angle });
    }
  };

  opTimeSubmenu = () => {
    if (this.state.timeClass === opMenu) {
      this.setState({ timeSubmenu: clSubMenu });
      this.setState({ timeClass: clMenu });
      this.setState({ timeMoreIcon: close });
    } else {
      this.setState({ timeSubmenu: opSubMenu });
      this.setState({ timeClass: opMenu });
      this.setState({ timeMoreIcon: angle });
    }
  };

  opLeaveSubmenu = () => {
    if (this.state.leaveClass === opMenu) {
      this.setState({ leaveSubmenu: clSubMenu });
      this.setState({ leaveClass: clMenu });
      this.setState({ leaveMoreIcon: close });
    } else {
      this.setState({ leaveSubmenu: opSubMenu });
      this.setState({ leaveClass: opMenu });
      this.setState({ leaveMoreIcon: angle });
    }
  };

  opOvertimeSubmenu = () => {
    if (this.state.overtimeClass === opMenu) {
      this.setState({ overtimeSubmenu: clSubMenu });
      this.setState({ overtimeClass: clMenu });
      this.setState({ overtimeMoreIcon: close });
    } else {
      this.setState({ overtimeSubmenu: opSubMenu });
      this.setState({ overtimeClass: opMenu });
      this.setState({ overtimeMoreIcon: angle });
    }
  };

  opSlide = () => {
    if (this.state.appClass === 'app') {
      this.setState({ appClass: 'app app-side-big-icon' });
      this.setState({ appButtonClass: 'fa fa-lg fa-bars' });
    } else {
      this.setState({ appClass: 'app' });
      this.setState({ appButtonClass: 'fa fa-lg fa-times' });
    }
  };

  createList = () => {
    let dt = [];

    for (let i = 0; i < 10; i++) {
      dt.push(
        <NavLink to={'/components/' + i}>
          <li className='content'>
            <div className='list'>
              <div className='icn'>
                <i className='fa fa-lg fa-th'></i>
              </div>
              <div className='ttl'>Components {i}</div>
            </div>
          </li>
        </NavLink>
      );
    }

    return dt;
  };

  createSubMenu = (val, link, icon) => {
    return (
      <NavLink to={link}>
        <div className='content'>
          <div className='list'>
            <div className='icn'>
              <i className={`${icon} fa-lg`} ></i>
            </div>
            <div className='ttl'>{val}</div>
            <div className='icn icn-right txt-site txt-right txt-12'></div>
          </div>
        </div>
      </NavLink>
    );
  };

  checkPermissionSubMenu = (valMenu, valSubmenu) => {
    //static response for the moment, 
    //will be activated later when authorization is ready to use
    return true;
    for (let indexData in this.state.menuData) {
      let item = this.state.menuData[indexData];
      if (item.menuId === valMenu) {
        let listForm = item.listForm;
        for (let indexSubData in listForm) {
          let subItem = listForm[indexSubData];
          if (subItem.formId === valSubmenu) {
            return true;
          }
        }
        break;
      }
    }
    return false;
  }

  checkPermissionMenu = (val) => {
    return true;
    let isFound = false;
    for (let indexData in this.state.menuData) {
      let item = this.state.menuData[indexData];
      if (item.menuId === val) {
        isFound = true;
        break;
      }
    }
    return isFound;
  }

  checkPermissionMenuDashboard = (val) => {
    return true;
    let isFound = false
    for (let indexData in this.state.menuData) {
      let item = this.state.menuData[indexData];
      if (item.menuId === val) {
        let index = R.findIndex(R.propEq('formId', 'DASHBOARD-001'))(item.listForm)
        isFound = index >= 0 ? true : false
        break;
      }
    }
    return isFound;
  }


  getMenuAccess = () => {

    // console.log("-----CALLED--------");
    if (this.props.auth && this.props.auth.user != null
      && !this.props.auth.error) {
      // console.log(this.props.auth.user);
      // console.log("---1----"+this.props.auth.user.jwtToken);
      // console.log("---2----"+this.state.lastMenuData);
      if (this.state.lastMenuData !== this.props.auth.user.jwtToken) {
        //dont update after being initialized
        if (this.state.menuData.length === 0 && this.props.auth.user.listMenu) {
          this.setState(
            {
              menuData: this.props.auth.user.listMenu,
              lastMenuData: this.props.auth.user.jwtToken,
              userCategory: this.props.auth.user.userCategory
            });
        } else {
          this.setState(
            {
              menuData: [],
              lastMenuData: this.props.auth.user.jwtToken,
              userCategory: this.props.auth.user.userCategory
            });
          return false;
        }
      }
    } else {
      // console.log("--------1111-------------");
      if (this.state.lastMenuData.trim() === "") {
        // console.log("--------1113-------------");
      } else {
        //backup store
        let authStore = localStorage.getItem("authStore");
        if (R.isNil(authStore)) {
          this.setState(
            {
              menuData: [],
              lastMenuData: ""
            });
        } else {
          authStore = JSON.parse(authStore);
          this.setState(
            {
              menuData: authStore.listMenu,
              lastMenuData: authStore.jwtToken,
            });
        }
      }
    }
  }

  componentDidMount() {
    this.getMenuAccess();
  }

  componentDidUpdate() {
    this.getMenuAccess();
  }

  render() {

    return (

      <HashRouter history={Router.browserHistory}>
        <div>
          {/* Multiple Page */}
          <div className={this.state.appClass}>
            <div className='app-slide'>
              <div className='slide-content background-blue'>
                <div className='app-title'>
                  <div className='col-1'>
                    <h1 className='txt-site txt-white txt-upp txt-18 txt-bold post-center margin-left-10px'>PROHACE</h1>
                  </div>
                  <div className='col-2'>
                    <button className='btn btn-blue btn-circle' onClick={this.opSlide}>
                      <i className={this.state.appButtonClass} />
                    </button>
                  </div>
                </div>
                <div className='slide-list change-scrollbar'>

                  {/* -------------START MENU------------- */}
                  <div>
                    <NavLink to={'/home'}>
                      <div className='app-space'>
                        <input type='checkbox' name='mainmenu' id='dashboard' />
                        <label htmlFor='dashboard' className='list'>
                          <span className='app-space-icon'>
                            <i className={`fas fa-home fa-lg`} style={{ color: "#fff" }} ></i>
                          </span>
                          <span className='app-space-text'>DASHBOARD</span>
                        </label>
                      </div>
                    </NavLink>
                  </div>

                  {this.checkPermissionMenu("MASTER") &&
                    <div className='app-space'>
                      <input type='checkbox' name='mainmenu' id='mainmenu-master-data' />
                      <label htmlFor='mainmenu-master-data' className='list'>
                        <span className='app-space-icon'>
                          <img src={require('../assets/img/icons/master-data.png')} alt='' />
                        </span>
                        <span className='app-space-text'>MASTERDATA</span>
                        <span className='app-space-sign'></span>
                      </label>
                      <div className='app-space-content'>
                        <div className='app-menu'>
                          {this.checkPermissionSubMenu('MASTER', 'MASTER-022') && this.createSubMenu('User Management', '/master/user-matrix', 'fa fa-lg fa-user')}
                        </div>
                      </div>
                    </div>
                  }

                </div>
              </div>
            </div>

            <div className='app-main'>
              <div className='app-panel'>
                <div className='panel-content'>
                  <div className='col-1'>
                    {/* <div>
                      <SearchPopup />
                    </div> */}
                    <div className='margin-5px'>
                      <img width="45%" src={logoProhace} alt="" />
                    </div>
                  </div>

                  <div className='col-2 content-right'>
                    {/* <div className="panel-button app-desktop">
	                    <CreatePopup />
	                  </div> */}
                    {/* <div className="panel-button app-desktop" style={{marginLeft: "10px"}}>
	                    <ChatPopup />
	                  </div> */}
                    <div className="panel-button app-desktop" style={{ marginLeft: "10px" }}>
                      <NotifPopup />
                    </div>
                    <div className='panel-button'>
                      <ProfilePopup />
                    </div>
                  </div>
                </div>
              </div>
              <div className='app-place'>
                {/* MASTER DATA */}
                <Route exact path="/master/user-matrix" component={User} />
                {/* Dashboard */}
                <Route exact path="/home" component={DashboardEmployee} />
              </div>
            </div>
          </div>
          {/* Single Page */}
          <div className='app'>
            <Route exact path='/' component={Login} />
          </div>
        </div>
      </HashRouter>
    );
  }
}

const mapStateToProps = (state) => {
  return {
    auth: state.auth,
  };
};

export default connect(mapStateToProps, null)(App);
