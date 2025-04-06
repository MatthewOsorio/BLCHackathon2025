// import viewMore from '../assets/icons/view-more-icon.png';

import "../ProfileLayout.css"
function ProfileLayout({profile}) {

    function Click() {
        alert("clicked")
    }

    function Text({display}) {
    return (
      <div>
        <p>{display}</p>
      </div>
    )
    }

        return <div className = "profile-page">
            <div className = "profile-picture"> 
                <img src = {profile.url} alt = {profile.name}/>
                <div className = "profile-overlay"> 
                <div className = "profile-info">
                    <h2>{profile.name}</h2>
                    <h6>{profile.university}</h6>
                    <p>{profile.aboutMe}</p>   
                </div>
                    <button className = "showMore" onClick = {Click}>
                        {/* <img src = {viewMore}/> */}
                        <Text display = "View More"/>
                    </button>
                    <button className = "messages" onClick = {Click}>
                        <Text display = "Message"/>
                    </button>
                    <button className = "edit" onClick = {Click}>
                        <Text display = "Edit"/>
                    </button>
                    <button className = "findARoomate" onClick = {Click}>
                        <Text display = "Find a Roomate"/>
                    </button>
                </div>
            </div>
    </div>
}


export default ProfileLayout