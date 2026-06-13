async function analyzeResume() {

    const resumeFile =
        document.getElementById("resume").files[0];

    const jobDescription =
        document.getElementById("jobDescription").value;

    if (!resumeFile) {
        alert("Please upload a resume.");
        return;
    }

    const formData = new FormData();

    formData.append("resume", resumeFile);
    formData.append("jobDescription", jobDescription);

    try {

        const response =
            await fetch("/api/analyze", {
                method: "POST",
                body: formData
            });

        const data =
            await response.json();

        document.getElementById("score")
            .innerText = data.score + "%";

        let skillsHtml = "";

        data.skills.forEach(skill => {
            skillsHtml += `<li>${skill}</li>`;
        });

        document.getElementById("skills")
            .innerHTML = skillsHtml;

        let missingHtml = "";

        data.missing.forEach(skill => {
            missingHtml += `<li>${skill}</li>`;
        });

        document.getElementById("missingSkills")
            .innerHTML = missingHtml;

    } catch (error) {

        console.error(error);

        alert("Error connecting to server");
    }
}